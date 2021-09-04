package top.buukle.opensource.arche.generator.service.engine;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.CompositeResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StartsWithMatcher;
import org.springframework.beans.BeanUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * 对原模板引擎进行改造，使其支持file和classpath两类加载模式
 */
public class MyBeetlTemplateEngine extends AbstractTemplateEngine {

    private GroupTemplate groupTemplate;

    private String templateStoreDir;

    public MyBeetlTemplateEngine(String templateStoreDir) {
        this.templateStoreDir = templateStoreDir;
        try {
            logger.info("模板根目录为：" + templateStoreDir);
            ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader(this.getClass().getClassLoader());
            FileResourceLoader fileResourceLoader = new FileResourceLoader(templateStoreDir);
            CompositeResourceLoader loader = new CompositeResourceLoader();
            loader.addResourceLoader(new StartsWithMatcher("classpath:").withoutPrefix(), classpathResourceLoader);
            loader.addResourceLoader(new StartsWithMatcher("file:").withoutPrefix(), fileResourceLoader);
            Configuration cfg = Configuration.defaultConfiguration();
            groupTemplate = new GroupTemplate(loader, cfg);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * @description 重写批量生成方法,从数据库模板记录中动态获取包名
     * @param
     * @return com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine
     * @Author 17600
     * @Date 2021/9/5
     */
    @Override
    public AbstractTemplateEngine batchOutput() {
        try {
            List<TableInfo> tableInfoList = getConfigBuilder().getTableInfoList();
            for (TableInfo tableInfo : tableInfoList) {
                Map<String, Object> objectMap = getObjectMap(tableInfo);
                // 自定义内容
                InjectionConfig injectionConfig = getConfigBuilder().getInjectionConfig();
                if (null != injectionConfig) {
                    injectionConfig.initTableMap(tableInfo);
                    objectMap.put("cfg", injectionConfig.getMap());
                    List<FileOutConfig> focList = injectionConfig.getFileOutConfigList();
                    if (CollectionUtils.isNotEmpty(focList)) {
                        for (FileOutConfig foc : focList) {
                            if (isCreate(FileType.OTHER, foc.outputFile(tableInfo))) {
                                MyTableInfo myTableInfo = new MyTableInfo();
                                BeanUtils.copyProperties(tableInfo,myTableInfo);
                                String outputFile = foc.outputFile(myTableInfo);
                                objectMap.put("packageInfo",myTableInfo.getPackageInfo());
                                writerFile(objectMap, foc.getTemplatePath(), outputFile);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("无法创建文件，请检查配置信息！", e);
        }
        return this;
    }

    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        if (templatePath.startsWith("file:")) {
            templatePath = templatePath.replace(templateStoreDir, "");
        }
        logger.info("templatePath:" + templatePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            Template template = groupTemplate.getTemplate(templatePath);
            template.binding(objectMap);
            template.renderTo(fileOutputStream);
            logger.info("已生成文件:" + outputFile);
        }catch (Exception e){
            logger.info("生成文件出错:" + outputFile);
        }

    }

    @Override
    public String templateFilePath(String filePath) {
        return filePath;
    }

}
