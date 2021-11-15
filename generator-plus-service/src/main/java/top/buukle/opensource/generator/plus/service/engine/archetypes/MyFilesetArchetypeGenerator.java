package top.buukle.opensource.generator.plus.service.engine.archetypes;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.archetype.ArchetypeGenerationRequest;
import org.apache.maven.archetype.common.ArchetypeArtifactManager;
import org.apache.maven.archetype.common.ArchetypeFilesResolver;
import org.apache.maven.archetype.common.Constants;
import org.apache.maven.archetype.common.PomManager;
import org.apache.maven.archetype.exception.*;
import org.apache.maven.archetype.generator.FilesetArchetypeGenerator;
import org.apache.maven.archetype.metadata.*;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.codehaus.plexus.logging.AbstractLogEnabled;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.StringUtils;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Slf4j
@Component
public class MyFilesetArchetypeGenerator
    extends AbstractLogEnabled
    implements FilesetArchetypeGenerator
{
    @Autowired
    private ArchetypeArtifactManager archetypeArtifactManager;

    @Autowired
    private ArchetypeFilesResolver archetypeFilesResolver;

    @Autowired
    private PomManager pomManager;

    /**
     * Token delimiter.
     */
    private static final String DELIMITER = "__";

    /**
     * Pattern used to detect tokens in a string. Tokens are any text surrounded
     * by the delimiter.
     */
    private static final Pattern TOKEN_PATTERN = Pattern.compile( ".*" + DELIMITER + ".*" + DELIMITER + ".*" );

    public void generateArchetype( ArchetypeGenerationRequest myArchetypeGenerationRequest, File archetypeFile ) throws UnknownArchetype, ArchetypeNotConfigured, ProjectDirectoryExists, PomFileExists, OutputFileExists,ArchetypeGenerationFailure{

        MyArchetypeGenerationRequest request = (MyArchetypeGenerationRequest) myArchetypeGenerationRequest;
        ClassLoader old = Thread.currentThread().getContextClassLoader();

        try{
            ArchetypeDescriptor archetypeDescriptor =
                archetypeArtifactManager.getFileSetArchetypeDescriptor( archetypeFile );
            if ( !isArchetypeConfigured( archetypeDescriptor, request ) ){
                if ( request.isInteractiveMode() ){
                    throw new ArchetypeNotConfigured( "No archetype was chosen.", null );
                }

                StringBuffer exceptionMessage = new StringBuffer(
                    "Archetype " + request.getArchetypeGroupId() + ":" + request.getArchetypeArtifactId() + ":"
                        + request.getArchetypeVersion() + " is not configured" );

                List<String> missingProperties = new ArrayList<String>( 0 );
                for ( RequiredProperty requiredProperty : archetypeDescriptor.getRequiredProperties() ) {
                    if ( StringUtils.isEmpty( request.getProperties().getProperty( requiredProperty.getKey() ) ) ) {
                        exceptionMessage.append( "\n\tProperty " + requiredProperty.getKey() + " is missing." );

                        missingProperties.add( requiredProperty.getKey() );
                    }
                }
                throw new ArchetypeNotConfigured( exceptionMessage.toString(), missingProperties );
            }

            Context context = prepareVelocityContext( request );

            String packageName = request.getPackage();
            String artifactId = request.getArtifactId();
            File outputDirectoryFile = new File( request.getOutputDirectory(), artifactId );
            File basedirPom = new File( request.getOutputDirectory(), Constants.ARCHETYPE_POM );
            File pom = new File( outputDirectoryFile, Constants.ARCHETYPE_POM );

            List<String> archetypeResources = archetypeArtifactManager.getFilesetArchetypeResources( archetypeFile );

            ZipFile archetypeZipFile = archetypeArtifactManager.getArchetypeZipFile( archetypeFile );

            ClassLoader archetypeJarLoader = archetypeArtifactManager.getArchetypeJarLoader( archetypeFile );

            Thread.currentThread().setContextClassLoader( archetypeJarLoader );

            if ( archetypeDescriptor.isPartial() )
            {
               log.debug( "Processing partial archetype " + archetypeDescriptor.getName() );
                if ( outputDirectoryFile.exists() )
                {
                    if ( !pom.exists() )
                    {
                        throw new PomFileExists( "This is a partial archetype and the pom.xml file doesn't exist." );
                    }

                    processPomWithMerge(request, context, pom, "" );

                    processArchetypeTemplatesWithWarning(request, archetypeDescriptor, archetypeResources, archetypeZipFile, "",
                                                          context, packageName, outputDirectoryFile );
                }
                else
                {
                    if ( basedirPom.exists() )
                    {
                        processPomWithMerge(request, context, basedirPom, "" );

                        processArchetypeTemplatesWithWarning(request, archetypeDescriptor, archetypeResources, archetypeZipFile,
                                                              "", context, packageName,
                                                              new File( request.getOutputDirectory() ) );
                    }
                    else
                    {
                        processPom(request, context, pom, "" );

                        processArchetypeTemplates(request, archetypeDescriptor, archetypeResources, archetypeZipFile, "",
                                                   context, packageName, outputDirectoryFile );
                    }
                }

                if ( archetypeDescriptor.getModules().size() > 0 )
                {
                   log.info( "Modules ignored in partial mode" );
                }
            }
            else
            {
               log.debug( "Processing complete archetype " + archetypeDescriptor.getName() );
                if ( outputDirectoryFile.exists() && pom.exists() )
                {
                    throw new ProjectDirectoryExists(
                        "A Maven 2 project already exists in the directory " + outputDirectoryFile.getPath() );
                }

                if ( outputDirectoryFile.exists() )
                {
                   log.warn( "The directory " + outputDirectoryFile.getPath() + " already exists." );
                }

                context.put( "rootArtifactId", artifactId );

                processFilesetModule(request, artifactId, artifactId, archetypeResources, pom, archetypeZipFile, "", basedirPom,
                                      outputDirectoryFile, packageName, archetypeDescriptor, context );
            }

            String postGenerationScript = archetypeArtifactManager.getPostGenerationScript( archetypeFile );
            if ( postGenerationScript != null )
            {
               log.info( "Executing " + Constants.ARCHETYPE_POST_GENERATION_SCRIPT
                    + " post-generation script" );

                Binding binding = new Binding();

                final Properties archetypeGeneratorProperties = new Properties();
                archetypeGeneratorProperties.putAll( System.getProperties() );

                if ( request.getProperties() != null )
                {
                    archetypeGeneratorProperties.putAll( request.getProperties() );
                }

                for ( Map.Entry<Object, Object> entry : archetypeGeneratorProperties.entrySet() )
                {
                    binding.setVariable( entry.getKey().toString(), entry.getValue() );
                }

                binding.setVariable( "request", request );

                GroovyShell shell = new GroovyShell( binding );
                shell.evaluate( postGenerationScript );
            }

            // ----------------------------------------------------------------------
            // Log message on OldArchetype creation
            // ----------------------------------------------------------------------
            if (log.isInfoEnabled() )
            {
               log.info( "Project created from Archetype in dir: " + outputDirectoryFile.getAbsolutePath() );
            }
        }
        catch ( FileNotFoundException ex )
        {
            throw new ArchetypeGenerationFailure( ex );
        }
        catch ( IOException ex )
        {
            throw new ArchetypeGenerationFailure( ex );
        }
        catch ( XmlPullParserException ex )
        {
            throw new ArchetypeGenerationFailure( ex );
        }
        catch ( DocumentException ex )
        {
            throw new ArchetypeGenerationFailure( ex );
        }
        catch ( ArchetypeGenerationFailure ex )
        {
            throw new ArchetypeGenerationFailure( ex );
        }
        catch ( InvalidPackaging ex )
        {
            throw new ArchetypeGenerationFailure( ex );
        }
        finally
        {
            Thread.currentThread().setContextClassLoader( old );
        }
    }

    public String getPackageAsDirectory( String packageName )
    {
        return StringUtils.replace( packageName, ".", "/" );
    }

    private boolean copyFile( final File outFile, final String template, final boolean failIfExists,
                              final ZipFile archetypeZipFile )
        throws FileNotFoundException, OutputFileExists, IOException
    {
       log.debug( "Copying file " + template );

        if ( failIfExists && outFile.exists() )
        {
            throw new OutputFileExists( "Don't rewrite file " + outFile.getName() );
        }
        else if ( outFile.exists() )
        {
           log.warn( "CP Don't override file " + outFile );

            return false;
        }

        ZipEntry input = archetypeZipFile.getEntry( Constants.ARCHETYPE_RESOURCES + "/" + template );

        if ( input.isDirectory() )
        {
            outFile.mkdirs();
        }
        else
        {
            InputStream inputStream = null;
            OutputStream out = null;
            try
            {
                inputStream = archetypeZipFile.getInputStream( input );

                outFile.getParentFile().mkdirs();

                out = new FileOutputStream( outFile );

                IOUtil.copy( inputStream, out );
            }
            finally
            {
                IOUtil.close( inputStream );
                IOUtil.close( out );
            }
        }

        return true;
    }

    private int copyFiles( String directory, List<String> fileSetResources, boolean packaged, String packageName,
                           File outputDirectoryFile, ZipFile archetypeZipFile, String moduleOffset,
                           boolean failIfExists, Context context )
        throws OutputFileExists, FileNotFoundException, IOException
    {
        int count = 0;

        for ( String template : fileSetResources )
        {
            File outputFile =
                getOutputFile( template, directory, outputDirectoryFile, packaged, packageName, moduleOffset, context );

            if ( copyFile( outputFile, template, failIfExists, archetypeZipFile ) )
            {
                count++;
            }
        }

        return count;
    }

    private String getEncoding( String archetypeEncoding )
    {
        return StringUtils.isEmpty( archetypeEncoding ) ? "UTF-8" : archetypeEncoding;
    }

    private String getOffsetSeparator( String moduleOffset )
    {
        return StringUtils.isEmpty( moduleOffset ) ? "/" : ( "/" + moduleOffset + "/" );
    }

    private File getOutputFile( String template, String directory, File outputDirectoryFile, boolean packaged,
                                String packageName, String moduleOffset, Context context )
    {
        String templateName = StringUtils.replaceOnce( template, directory, "" );

        String outputFileName =
            directory + "/" + ( packaged ? getPackageAsDirectory( packageName ) : "" ) + "/" + templateName.substring(
                moduleOffset.length() );

        if ( TOKEN_PATTERN.matcher( outputFileName ).matches() )
        {
            outputFileName = replaceFilenameTokens( outputFileName, context );
        }

        return new File( outputDirectoryFile, outputFileName );
    }

    /**
     * Replaces all tokens (text surrounded by the {@link #DELIMITER}) within
     * the given string, using properties contained within the context. If a
     * property does not exist in the context, the token is left unmodified
     * and a warning is logged.
     *
     * @param filePath the file name and path to be interpolated
     * @param context  contains the available properties
     */
    private String replaceFilenameTokens( final String filePath, final Context context )
    {
        String interpolatedResult = filePath;

        int start = 0;

        while ( true )
        {
            start = interpolatedResult.indexOf( DELIMITER, start );

            if ( start == -1 )
            {
                break;
            }

            int end = interpolatedResult.indexOf( DELIMITER, start + DELIMITER.length() );

            if ( end == -1 )
            {
                break;
            }

            String propertyToken = interpolatedResult.substring( start + DELIMITER.length(), end );

            String contextPropertyValue = (String) context.get( propertyToken );

            if ( contextPropertyValue != null && contextPropertyValue.trim().length() > 0 )
            {
                String search = DELIMITER + propertyToken + DELIMITER;

                if (log.isDebugEnabled() )
                {
                   log.debug(
                        "Replacing '" + search + "' in file path '" + interpolatedResult + "' with value '"
                            + contextPropertyValue + "'." );
                }

                interpolatedResult = StringUtils.replace( interpolatedResult, search, contextPropertyValue );

                end = end + contextPropertyValue.length() - search.length();
            }
            else
            {
                // Need to skip the undefined property
               log.warn(
                    "Property '" + propertyToken + "' was not specified, so the token in '" + interpolatedResult
                        + "' is not being replaced." );
            }

            start = end + DELIMITER.length() + 1;
        }

        if (log.isDebugEnabled() )
        {
           log.debug( "Final interpolated file path: '" + interpolatedResult + "'" );
        }

        return interpolatedResult;
    }

    private String getPackageInPathFormat( String aPackage )
    {
        return StringUtils.replace( aPackage, ".", "/" );
    }

    private boolean isArchetypeConfigured( ArchetypeDescriptor archetypeDescriptor, ArchetypeGenerationRequest request )
    {
        for ( RequiredProperty requiredProperty : archetypeDescriptor.getRequiredProperties() )
        {
            if ( StringUtils.isEmpty( request.getProperties().getProperty( requiredProperty.getKey() ) ) )
            {
                return false;
            }
        }

        return true;
    }

    private void setParentArtifactId( Context context, String artifactId )
    {
        context.put( Constants.PARENT_ARTIFACT_ID, artifactId );
    }

    private Context prepareVelocityContext( ArchetypeGenerationRequest request )
    {
        Context context = new VelocityContext();
        context.put( Constants.GROUP_ID, request.getGroupId() );
        context.put( Constants.ARTIFACT_ID, request.getArtifactId() );
        context.put( Constants.VERSION, request.getVersion() );
        context.put( Constants.PACKAGE, request.getPackage() );
        final String packageInPathFormat = getPackageInPathFormat( request.getPackage() );
        context.put( Constants.PACKAGE_IN_PATH_FORMAT, packageInPathFormat );

        if (log.isInfoEnabled() )
        {
           log.info( "----------------------------------------------------------------------------" );

           log.info(
                "Using following parameters for creating project from Archetype: " + request.getArchetypeArtifactId()
                    + ":" + request.getArchetypeVersion() );

           log.info( "----------------------------------------------------------------------------" );
           log.info( "Parameter: " + Constants.GROUP_ID + ", Value: " + request.getGroupId() );
           log.info( "Parameter: " + Constants.ARTIFACT_ID + ", Value: " + request.getArtifactId() );
           log.info( "Parameter: " + Constants.VERSION + ", Value: " + request.getVersion() );
           log.info( "Parameter: " + Constants.PACKAGE + ", Value: " + request.getPackage() );
           log.info( "Parameter: " + Constants.PACKAGE_IN_PATH_FORMAT + ", Value: " + packageInPathFormat );
        }

        for ( Iterator<?> iterator = request.getProperties().keySet().iterator(); iterator.hasNext(); )
        {
            String key = (String) iterator.next();

            String value = request.getProperties().getProperty( key );

            if ( maybeVelocityExpression( value ) )
            {
                value = evaluateExpression( context, key, value );
            }

            context.put( key, value );

            if (log.isInfoEnabled() )
            {
               log.info( "Parameter: " + key + ", Value: " + value );
            }
        }
        return context;
    }

    private boolean maybeVelocityExpression( String value )
    {
        return value != null && value.contains( "${" );
    }

    private String evaluateExpression( Context context, String key, String value )
    {
        StringWriter stringWriter = new StringWriter();
        try
        {
            Velocity.evaluate( context, stringWriter, key, value );
            return stringWriter.toString();
        }
        catch ( Exception ex )
        {
            return value;
        }
        finally
        {
            IOUtil.close( stringWriter );
        }

    }

    private void processArchetypeTemplates(MyArchetypeGenerationRequest request, AbstractArchetypeDescriptor archetypeDescriptor,
                                           List<String> archetypeResources, ZipFile archetypeZipFile,
                                           String moduleOffset, Context context, String packageName,
                                           File outputDirectoryFile)
        throws OutputFileExists, ArchetypeGenerationFailure, FileNotFoundException, IOException
    {
        processTemplates( request,packageName, outputDirectoryFile, context, archetypeDescriptor, archetypeResources,
                          archetypeZipFile, moduleOffset, false );
    }

    private void processArchetypeTemplatesWithWarning(MyArchetypeGenerationRequest request, ArchetypeDescriptor archetypeDescriptor,
                                                      List<String> archetypeResources, ZipFile archetypeZipFile,
                                                      String moduleOffset, Context context, String packageName,
                                                      File outputDirectoryFile)
        throws OutputFileExists, ArchetypeGenerationFailure, FileNotFoundException, IOException
    {
        processTemplates(request, packageName, outputDirectoryFile, context, archetypeDescriptor, archetypeResources,
                          archetypeZipFile, moduleOffset, true );
    }

    private int processFileSet(MyArchetypeGenerationRequest request, String directory, List<String> fileSetResources, boolean packaged, String packageName,
                               Context context, File outputDirectoryFile, String moduleOffset,
                               String archetypeEncoding, boolean failIfExists)
        throws OutputFileExists, ArchetypeGenerationFailure
    {
        int count = 0;

        for ( String template : fileSetResources )
        {
            File outputFile =
                getOutputFile( template, directory, outputDirectoryFile, packaged, packageName, moduleOffset, context );

            if ( processTemplate(request, outputFile, context, Constants.ARCHETYPE_RESOURCES + "/" + template,
                                  archetypeEncoding, failIfExists ) )
            {
                count++;
            }
        }

        return count;
    }

    private void processFilesetModule(MyArchetypeGenerationRequest request, final String rootArtifactId, final String artifactId,
                                      final List<String> archetypeResources, File pom, final ZipFile archetypeZipFile,
                                      String moduleOffset, File basedirPom, File outputDirectoryFile,
                                      final String packageName, final AbstractArchetypeDescriptor archetypeDescriptor,
                                      final Context context)
        throws DocumentException, XmlPullParserException, ArchetypeGenerationFailure, InvalidPackaging, IOException,
        OutputFileExists
    {
        outputDirectoryFile.mkdirs();
       log.debug( "Processing module " + artifactId );
       log.debug( "Processing module rootArtifactId " + rootArtifactId );
       log.debug( "Processing module pom " + pom );
       log.debug( "Processing module moduleOffset " + moduleOffset );
       log.debug( "Processing module outputDirectoryFile " + outputDirectoryFile );

        processFilesetProject( request,archetypeDescriptor,
                               StringUtils.replace( artifactId, "${rootArtifactId}", rootArtifactId ),
                               archetypeResources, pom, archetypeZipFile, moduleOffset, context, packageName,
                               outputDirectoryFile, basedirPom );

        String parentArtifactId = (String) context.get( Constants.PARENT_ARTIFACT_ID );

        Iterator<ModuleDescriptor> subprojects = archetypeDescriptor.getModules().iterator();

        if ( subprojects.hasNext() )
        {
           log.debug( artifactId + " has modules (" + archetypeDescriptor.getModules() + ")" );

            setParentArtifactId( context, StringUtils.replace( artifactId, "${rootArtifactId}", rootArtifactId ) );
        }

        while ( subprojects.hasNext() )
        {
            ModuleDescriptor project = subprojects.next();

            String modulePath = StringUtils.replace( project.getDir(), "__rootArtifactId__", rootArtifactId );
            modulePath = replaceFilenameTokens( modulePath, context );
            
            File moduleOutputDirectoryFile = new File( outputDirectoryFile, modulePath );

            context.put( Constants.ARTIFACT_ID,
                         StringUtils.replace( project.getId(), "${rootArtifactId}", rootArtifactId ) );
            
            String moduleArtifactId = StringUtils.replace( project.getDir(), "__rootArtifactId__", rootArtifactId );
            moduleArtifactId = replaceFilenameTokens( moduleArtifactId, context );
            
            processFilesetModule(request, rootArtifactId, moduleArtifactId,
                                  archetypeResources, new File( moduleOutputDirectoryFile, Constants.ARCHETYPE_POM ),
                                  archetypeZipFile,
                                  ( StringUtils.isEmpty( moduleOffset ) ? "" : ( moduleOffset + "/" ) )
                                      + StringUtils.replace( project.getDir(), "${rootArtifactId}", rootArtifactId ),
                                  pom, moduleOutputDirectoryFile, packageName, project, context );
        }

        restoreParentArtifactId( context, parentArtifactId );

       log.debug( "Processed " + artifactId );
    }

    private void processFilesetProject(MyArchetypeGenerationRequest request, final AbstractArchetypeDescriptor archetypeDescriptor, final String moduleId,
                                       final List<String> archetypeResources, final File pom,
                                       final ZipFile archetypeZipFile, String moduleOffset, final Context context,
                                       final String packageName, final File outputDirectoryFile,
                                       final File basedirPom)
        throws DocumentException, XmlPullParserException, ArchetypeGenerationFailure, InvalidPackaging, IOException,
        FileNotFoundException, OutputFileExists
    {
       log.debug( "Processing fileset project moduleId " + moduleId );
       log.debug( "Processing fileset project pom " + pom );
       log.debug( "Processing fileset project moduleOffset " + moduleOffset );
       log.debug( "Processing fileset project outputDirectoryFile " + outputDirectoryFile );
       log.debug( "Processing fileset project basedirPom " + basedirPom );

        if ( basedirPom.exists() )
        {
            processPomWithParent(request, context, pom, moduleOffset, basedirPom, moduleId );
        }
        else
        {
            processPom(request, context, pom, moduleOffset );
        }

        processArchetypeTemplates(request, archetypeDescriptor, archetypeResources, archetypeZipFile, moduleOffset, context,
                                   packageName, outputDirectoryFile );
    }

    private void processPom(MyArchetypeGenerationRequest request, Context context, File pom, String moduleOffset)
        throws OutputFileExists, ArchetypeGenerationFailure
    {
       log.debug( "Processing pom " + pom );

        processTemplate(request, pom, context,
                         Constants.ARCHETYPE_RESOURCES + getOffsetSeparator( moduleOffset ) + Constants.ARCHETYPE_POM,
                         getEncoding( null ), true );
    }

    private void processPomWithMerge(MyArchetypeGenerationRequest request, Context context, File pom, String moduleOffset)
        throws OutputFileExists, IOException, XmlPullParserException, ArchetypeGenerationFailure
    {
       log.debug( "Processing pom " + pom + " with merge" );

        File temporaryPom = getTemporaryFile( pom );

        processTemplate(request, temporaryPom, context,
                         Constants.ARCHETYPE_RESOURCES + getOffsetSeparator( moduleOffset ) + Constants.ARCHETYPE_POM,
                         getEncoding( null ), true );

        pomManager.mergePoms( pom, temporaryPom );

        // getTemporaryFile sets deleteOnExit. Lets try to delete and then make sure deleteOnExit is
        // still set. Windows has issues deleting files with certain JDKs.
        try
        {
            FileUtils.forceDelete( temporaryPom );
        }
        catch ( IOException e )
        {
            temporaryPom.deleteOnExit();
        }
    }

    private void processPomWithParent(MyArchetypeGenerationRequest request, Context context, File pom, String moduleOffset, File basedirPom,
                                      String moduleId)
        throws OutputFileExists, XmlPullParserException, DocumentException, IOException, InvalidPackaging,
        ArchetypeGenerationFailure
    {
       log.debug( "Processing pom " + pom + " with parent " + basedirPom );

        processTemplate(request, pom, context,
                         Constants.ARCHETYPE_RESOURCES + getOffsetSeparator( moduleOffset ) + Constants.ARCHETYPE_POM,
                         getEncoding( null ), true );

       log.debug( "Adding module " + moduleId );

        pomManager.addModule( basedirPom, moduleId );

        pomManager.addParent( pom, basedirPom );
    }

    @SuppressWarnings( "deprecation" )
    private boolean processTemplate(MyArchetypeGenerationRequest request, File outFile, Context context, String templateFileName, String encoding,
                                    boolean failIfExists)
        throws OutputFileExists, ArchetypeGenerationFailure
    {
        templateFileName = templateFileName.replace( File.separatorChar, '/' );

        String localTemplateFileName = templateFileName.replace( '/', File.separatorChar );
        VelocityEngine engine = request.getMyVelocityComponent().getEngine();
        boolean b = !engine.templateExists(templateFileName);
        boolean c = engine.templateExists(localTemplateFileName);
        if ( !templateFileName.equals( localTemplateFileName ) && b &&  c)
        {
            templateFileName = localTemplateFileName;
        }

       log.debug( "Processing template " + templateFileName );

        if ( outFile.exists() )
        {
            if ( failIfExists )
            {
                throw new OutputFileExists( "Don't override file " + outFile.getAbsolutePath() );
            }

           log.warn( "Don't override file " + outFile );

            return false;
        }

        if ( templateFileName.endsWith( "/" ) )
        {
           log.debug( "Creating directory " + outFile );

            outFile.mkdirs();

            return true;
        }

        if ( !outFile.getParentFile().exists() )
        {
            outFile.getParentFile().mkdirs();
        }

       log.debug( "Merging into " + outFile );

        Writer writer = null;

        try
        {
            StringWriter stringWriter = new StringWriter();

            request.getMyVelocityComponent().getEngine().mergeTemplate( templateFileName, encoding, context, stringWriter );

            writer = new OutputStreamWriter( new FileOutputStream( outFile ), encoding );

            writer.write( StringUtils.unifyLineSeparators( stringWriter.toString() ) );

            writer.flush();
        }
        catch ( Exception e )
        {
            throw new ArchetypeGenerationFailure( "Error merging velocity templates: " + e.getMessage(), e );
        }
        finally
        {
            IOUtil.close( writer );
        }

        return true;
    }

    private void processTemplates(MyArchetypeGenerationRequest request, String packageName, File outputDirectoryFile, Context context,
                                  AbstractArchetypeDescriptor archetypeDescriptor, List<String> archetypeResources,
                                  ZipFile archetypeZipFile, String moduleOffset, boolean failIfExists)
        throws OutputFileExists, ArchetypeGenerationFailure, FileNotFoundException, IOException
    {
        Iterator<FileSet> iterator = archetypeDescriptor.getFileSets().iterator();
        if ( iterator.hasNext() )
        {
           log.debug( "Processing filesets" + "\n  " + archetypeResources );
        }

        int count = 0;
        while ( iterator.hasNext() )
        {
            FileSet fileSet = iterator.next();
            count++;

            List<String> fileSetResources =
                archetypeFilesResolver.filterFiles( moduleOffset, fileSet, archetypeResources );

            // This creates an empty directory, even if there is no file to process
            // Fix for ARCHETYPE-57
            getOutputFile( moduleOffset, fileSet.getDirectory(), outputDirectoryFile, fileSet.isPackaged(), packageName,
                           moduleOffset, context ).mkdirs();

            if ( fileSet.isFiltered() )
            {
               log.debug( "    Processing fileset " + fileSet + " -> " + fileSetResources.size() + ":\n      "
                                       + fileSetResources );

                int processed =
                    processFileSet( request,fileSet.getDirectory(), fileSetResources, fileSet.isPackaged(), packageName,
                                    context, outputDirectoryFile, moduleOffset, getEncoding( fileSet.getEncoding() ),
                                    failIfExists );

               log.debug( "    Processed " + processed + " files." );
            }
            else
            {
               log.debug( "    Copying fileset " + fileSet + " -> " + fileSetResources.size() + ":\n      "
                                       + fileSetResources );

                int copied = copyFiles( fileSet.getDirectory(), fileSetResources, fileSet.isPackaged(), packageName,
                                        outputDirectoryFile, archetypeZipFile, moduleOffset, failIfExists, context );

               log.debug( "    Copied " + copied + " files." );
            }
        }

       log.debug( "Processed " + count + " filesets" );
    }

    private void restoreParentArtifactId( Context context, String parentArtifactId )
    {
        if ( StringUtils.isEmpty( parentArtifactId ) )
        {
            context.remove( Constants.PARENT_ARTIFACT_ID );
        }
        else
        {
            context.put( Constants.PARENT_ARTIFACT_ID, parentArtifactId );
        }
    }

    private File getTemporaryFile( File file )
    {
        File tmp = FileUtils.createTempFile( file.getName(), Constants.TMP, file.getParentFile() );

        tmp.deleteOnExit();

        return tmp;
    }
}
