package top.buukle.generator.service.impl;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.commons.call.vo.FuzzyVo;
import top.buukle.generator.commons.log.BaseLogger;
import top.buukle.generator.commons.mvc.BaseQuery;
import top.buukle.generator.commons.status.StatusConstants;
import top.buukle.generator.dao.*;
import top.buukle.generator.entity.*;
import top.buukle.generator.entity.constants.ConfiguresEnums;
import top.buukle.generator.entity.constants.ConfiguresExecuteEnums;
import top.buukle.generator.entity.constants.TemplatesEnums;
import top.buukle.generator.entity.vo.*;
import top.buukle.generator.invoker.DataBaseUtil;
import top.buukle.generator.invoker.enums.DatabaseType;
import top.buukle.generator.service.ConfiguresExecuteService;
import top.buukle.generator.service.ConfiguresService;
import top.buukle.generator.service.ConfiguresTemplatesRelationService;
import top.buukle.generator.service.constants.SystemReturnEnum;
import top.buukle.generator.service.engine.BeetlTemplateEngine;
import top.buukle.generator.service.exception.SystemException;
import top.buukle.generator.service.util.FileUtil;
import top.buukle.generator.service.util.ZipUtil;
import top.buukle.generator.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
* @author elvin
* @description ConfiguresService实现类
*/
@Service("configuresService")
public class ConfiguresServiceImpl implements ConfiguresService{

    private static final String GEN_TEMP_TEMPLATE_FILE = "/genTempTemplateFile/";
    private static final String TARGET_GENERATED_FILE = "/targetGeneratedFile/";
    private static final String SRC_FILE_PATH = "src/main/java/";
    private static final String RESOURCE_FILE_PATH = "src/main/resources/";
    private static final String FILE_PREFIX = "file:";
    private static final String IMPL_CONSTANT = "impl";
    private static final String WEB_CONSTANT = "web";
    private static final String VO_CONSTANT = "vo";
    private static final String XML_CONSTANT = "config/mapper";
    private static final String ZIP_CONSTANT = "zip";

    private static BaseLogger LOGGER = BaseLogger.getLogger(ConfiguresServiceImpl.class);

    @Autowired
    private ConfiguresMapper configuresMapper;
    @Autowired
    private ConfiguresTemplatesRelationMapper configuresTemplatesRelationMapper;
    @Autowired
    private ConfiguresTemplatesRelationService configuresTemplatesRelationService;
    @Autowired
    private ConfiguresExecuteService configuresExecuteService;
    @Autowired
    private ConfiguresExecuteMapper configuresExecuteMapper;
    @Autowired
    private TemplatesMapper templatesMapper;
    @Autowired
    private DatasourcesMapper datasourcesMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private Environment env;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((ConfiguresQuery)query).getPage(),((ConfiguresQuery)query).getPageSize());
        List<Configures> list = configuresMapper.selectByExample(this.assExampleForList(((ConfiguresQuery)query)));
        PageInfo<Configures> pageInfo = new PageInfo<>(list);
        return new PageResponse.Builder().build(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
    }

    /**
     * 根据id删除记录状态数据
     * @param id 删除数据实例
     * @param request httpServletRequest
     * @param response
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT ,rollbackFor = Exception.class)
    public CommonResponse delete(Integer id, HttpServletRequest request, HttpServletResponse response) {
        if(configuresMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, ConfiguresEnums.status.DELETED.value(),request,response)) != 1){
            throw new SystemException(SystemReturnEnum.DELETE_INFO_EXCEPTION);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 批量删除接口
     * @param ids
     * @param request
     * @param response
     * @return top.buukle.generator.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT ,rollbackFor = Exception.class)
    public CommonResponse deleteBatch(String ids, HttpServletRequest request, HttpServletResponse response) {
        String trimIds = ids.trim();
        String[] split = trimIds.split(",");
        if(StringUtil.isEmpty(trimIds) || split.length<1){
            throw new SystemException(SystemReturnEnum.DELETE_BATCH_IDS_NULL);
        }
        List<Integer> idList = JsonUtil.parseArray(JsonUtil.toJSONString(Arrays.asList(split)), Integer.class);
        ConfiguresExample configuresExample = new ConfiguresExample();
        ConfiguresExample.Criteria criteria = configuresExample.createCriteria();
        criteria.andIdIn(idList);
        Configures configures = new Configures();

        configures.setGmtModified(new Date());

        configures.setStatus(ConfiguresEnums.status.DELETED.value());
        configuresMapper.updateByExampleSelective(configures,configuresExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.top.buukle.generator .entity.Configures
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public ConfiguresQuery selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        ConfiguresQuery configuresQuery = new ConfiguresQuery();

        // 查询模板表
        TemplatesExample templatesExample = new TemplatesExample();
        TemplatesExample.Criteria templatesExampleCriteria = templatesExample.createCriteria();
        templatesExampleCriteria.andStatusIn(TemplatesEnums.allowStatus.ALLOW_STATUS.list());
        List<Templates> templatesAll = templatesMapper.selectByExample(templatesExample);
        if(id == null){
            List<Templates> templatesResult = new ArrayList<>();
            // 加工返回结构
            for(Templates templates : templatesAll){
                TemplatesQuery templatesQuery = new TemplatesQuery();
                BeanUtils.copyProperties(templates,templatesQuery);
                templatesQuery.setChecked(false);
                templatesResult.add(templatesQuery);
            }
            configuresQuery.setTemplatesList(templatesResult);
            return configuresQuery;
        }
        Configures configures = configuresMapper.selectByPrimaryKey(id);
        if(null != configures){
            BeanUtils.copyProperties(configures,configuresQuery);
        }
        /*处理表名列表*/
        Datasources datasources = datasourcesMapper.selectByPrimaryKey(configuresQuery.getDatasourcesId());
        configuresQuery.setDatasourcesName(datasources.getName());
        Connection connection = null;
        // 初始化配置表中记录的表名集合
        List<String> recordTables = StringUtil.parseStringToListComma(configuresQuery.getTables());
        // 初始化该条配置对应连接实时的表集合
        List<String> DBTables = new ArrayList<>();
        List<TableVo> tableVoList = new ArrayList<>();
        try {
            connection = DataBaseUtil.getConnection(DatabaseType.MySQL, datasources.getUsername(), datasources.getPassword(), datasources.getUrl());
            DBTables = DataBaseUtil.getTables(connection);
            connection.close();
        } catch (SQLException throwables) {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }
        // 实时查询失败,则只展示数据库中记录的表
        if(CollectionUtils.isEmpty(DBTables)){
            for (String tableName : recordTables) {
                TableVo tableVo = new TableVo();
                tableVo.setChecked(true);
                tableVo.setName(tableName);
                tableVoList.add(tableVo);
            }
        }
        // 实时查询连接中的表成功
        else{
            for (String dbTableName: DBTables) {
                TableVo tableVo = new TableVo();
                tableVo.setChecked(recordTables.contains(dbTableName));
                tableVo.setName(dbTableName);
                tableVoList.add(tableVo);
            }
        }
        configuresQuery.setTableList(tableVoList);

        /* 模板处理*/

        // 查询模板关系表
        ConfiguresTemplatesRelationExample configuresTemplatesRelationExample = new ConfiguresTemplatesRelationExample();
        ConfiguresTemplatesRelationExample.Criteria criteria = configuresTemplatesRelationExample.createCriteria();
        criteria.andConfiguresIdEqualTo(id);
        List<ConfiguresTemplatesRelation> configuresTemplatesRelations = configuresTemplatesRelationMapper.selectByExample(configuresTemplatesRelationExample);

        // 初始化一个集合用来查询是否存在
        List<Integer> hasRelationTemplatesIdList = new ArrayList<>();
        for(ConfiguresTemplatesRelation configuresTemplatesRelation : configuresTemplatesRelations){
            hasRelationTemplatesIdList.add(configuresTemplatesRelation.getTemplatesId());
        }

        // 初始化返回结构
        List<Templates> templatesResult = new ArrayList<>();
        List<Integer> templateIdsResult = new ArrayList<>();

        // 加工返回结构
        for(Templates templates : templatesAll){
            TemplatesQuery templatesQuery = new TemplatesQuery();
            BeanUtils.copyProperties(templates,templatesQuery);
            boolean contains = hasRelationTemplatesIdList.contains(templates.getId());
            templatesQuery.setChecked(contains);
            templatesResult.add(templatesQuery);
            if(contains){
                templateIdsResult.add(templates.getId());
            }
        }
        configuresQuery.setTemplatesList(templatesResult);
        configuresQuery.setTemplateIds(StringUtil.IntegerListToString(templateIdsResult));
        return configuresQuery;
    }

    /**
     * @description 新增或者修改提交接口
     * @param query
     * @param request
     * @param response
     * @return top.buukle.generator.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/5
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT ,rollbackFor = Exception.class)
    public CommonResponse saveOrEdit(ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response) {

        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){

            this.save(query,request,response);
            // 更新状态为通过
            ConfiguresQuery queryForUpdate = new ConfiguresQuery();
            queryForUpdate.setId(query.getId());
            queryForUpdate.setStatus(ConfiguresEnums.status.PUBLISHED.value());
            this.update(queryForUpdate,request,response);
        }
        // 更新
        else{
            this.update(query,request,response);
        }
        // 处理模板关系
        this.handleConfiguresTemplates(query,request,response);
        return new CommonResponse.Builder().buildSuccess();
    }


    @Override
    public CommonResponse gen(ConfiguresQuery queryFront, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 校验参数
        validateParam(queryFront);
        // 查询配置记录
        Configures configures = configuresMapper.selectByPrimaryKey(queryFront.getId());
        // 初始化日志记录
        ConfiguresExecuteQuery configuresExecuteQuery = new ConfiguresExecuteQuery();
        BeanUtils.copyProperties(configures,configuresExecuteQuery);
        configuresExecuteQuery.setId(null);
        configuresExecuteQuery.setConfiguresId(configures.getId());
        // 初始化日志记录连接信息
        Datasources datasourcesForExecute = datasourcesMapper.selectByPrimaryKey(configures.getDatasourcesId());
        configuresExecuteQuery.setDatabasesInfo(JsonUtil.toJSONString(datasourcesForExecute));
        // 初始化日志记录模板关系表
        ConfiguresTemplatesRelationExample configuresTemplatesRelationExample = new ConfiguresTemplatesRelationExample();
        ConfiguresTemplatesRelationExample.Criteria criteria = configuresTemplatesRelationExample.createCriteria();
        criteria.andConfiguresIdEqualTo(configures.getId());
        List<ConfiguresTemplatesRelation> configuresTemplatesRelations = configuresTemplatesRelationMapper.selectByExample(configuresTemplatesRelationExample);
        List<Templates> templatesList = new ArrayList<>();
        for (ConfiguresTemplatesRelation configuresTemplatesRelation: configuresTemplatesRelations) {
            Templates templates = templatesMapper.selectByPrimaryKey(configuresTemplatesRelation.getTemplatesId());
            templatesList.add(templates);
        }
        // 插入日志记录
        configuresExecuteQuery.setTemplatesInfo(JsonUtil.toJSONString(templatesList));
        configuresExecuteService.saveOrEdit(configuresExecuteQuery,request,response);

        // 更新执行记录状态为执行中
        configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.INIT.value(),ConfiguresExecuteEnums.status.EXECUTING.value(),configuresExecuteQuery.getId());
        String generatedFileStorePathZip;
        try {
            generatedFileStorePathZip = this.doGen(configures, configuresTemplatesRelations, request, response);
        } catch (Exception e) {
            // 更新执行记录状态为执行失败
            configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_FAILED.value(),configuresExecuteQuery.getId());
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_FAILED);
        }
        if(StringUtil.isEmpty(generatedFileStorePathZip)){
            // 更新执行记录状态为执行失败
            configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_FAILED.value(),configuresExecuteQuery.getId());
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_FAILED);
        }

        // 将本地临时的zip文件映射到静态资源路径,并更新日志记录的下载地址
        ConfiguresExecute configuresExecuteQueryForUpdate = new ConfiguresExecute();
        configuresExecuteQueryForUpdate.setId(configuresExecuteQuery.getId());
        String downUrl;
        if(SystemUtil.isWindows()){
            downUrl = generatedFileStorePathZip.replaceFirst("D://file",  env.getProperty("server.servlet.context-path") +  "/upload");
        }else{
            downUrl = generatedFileStorePathZip.replaceFirst("/opt",  env.getProperty("server.servlet.context-path") +  "/upload");
        }
        configuresExecuteQueryForUpdate.setZipDownUrl(downUrl);
        configuresExecuteMapper.updateByPrimaryKeySelective(configuresExecuteQueryForUpdate);
        // 更新执行记录状态为执行成功
        configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_SUCCESS.value(),configuresExecuteQuery.getId());
        return new CommonResponse.Builder<>().buildSuccess();
    }


    public String doGen(Configures query, List<ConfiguresTemplatesRelation> configuresTemplatesRelations, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String generatedFileStorePathZip = null;
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setAuthor(SessionUtil.getOperator(request,response).getUsername());
        globalConfig.setOpen(false);
        // 实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        // 数据源配置
        Datasources datasources = datasourcesMapper.selectByPrimaryKey(query.getDatasourcesId());
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(datasources.getUrl());
        dataSourceConfig.setDriverName(DatabaseType.MySQL.getDriverClazzName());
        dataSourceConfig.setUsername(datasources.getUsername());
        dataSourceConfig.setPassword(datasources.getPassword());
        autoGenerator.setDataSource(dataSourceConfig);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setController(TemplatesEnums.type.CONTROLLER.value());
        pc.setService(TemplatesEnums.type.SERVICE.value());
        pc.setEntity(TemplatesEnums.type.ENTITY.value());
        pc.setMapper(TemplatesEnums.type.DAO.value());
        pc.setParent(query.getBasePackage());
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        /* 自定义输出*/
        // 批次uuid
        String genBatchUuid = UUID.randomUUID().toString().replace( StringUtil.MIDDLE, StringUtil.EMPTY);
        // 按照模板信息进行生成
        if(!CollectionUtils.isEmpty(configuresTemplatesRelations)){
            // 初始化临时生成模板 的路径和 模板名称的映射
            Map<String,String> tempTemplateFileMap = new HashMap<>();
            Map<String,String> templateTypeMap = new HashMap<>();
            // 初始化模板所在文件根路径
            String tempTemplateFileRootPath = SystemUtil.getStoreDir() + StringUtil.BACKSLASH + genBatchUuid + GEN_TEMP_TEMPLATE_FILE;
            // 遍历加载该映射
            Templates templates;
            //不使用默认的配置,所有的文件都改为自定义生成
            TemplateConfig templateConfig = new TemplateConfig();
            templateConfig.disable(TemplateType.CONTROLLER,
                    TemplateType.ENTITY,
                    TemplateType.MAPPER,
                    TemplateType.SERVICE,
                    TemplateType.XML);
            for (ConfiguresTemplatesRelation configuresTemplatesRelation : configuresTemplatesRelations) {
                templates = templatesMapper.selectByPrimaryKey(configuresTemplatesRelation.getTemplatesId());
                // 生成临时模板文件
                String tempTemplateFilePath = this.genTempTemplateFile(tempTemplateFileRootPath,templates);
                tempTemplateFileMap.put(tempTemplateFilePath,templates.getName());
                templateTypeMap.put(tempTemplateFilePath,templates.getType());
            }
            autoGenerator.setTemplate(templateConfig);

            //配置输出目录
            globalConfig.setOutputDir(SystemUtil.getStoreDir() + StringUtil.BACKSLASH + genBatchUuid);
            autoGenerator.setGlobalConfig(globalConfig);
            // 初始化自定义模板
            List<FileOutConfig> fileOutConfigList = new ArrayList<>();

            // 初始化最终生成文件的服务端存储根路径
            String generatedFileStoreRootPath = SystemUtil.getStoreDir() + StringUtil.BACKSLASH +  genBatchUuid + TARGET_GENERATED_FILE;
            // 初始化最终生成文件的服务端存储路径集合
            Set<String> generatedFileStorePathSet = new HashSet<>();
            // 处理base包名
            String basePackage = query.getBasePackage();
            // 处理base模块名
            String basePackageModuleName = query.getBak01();
            String basePackageSrcFilePath = SRC_FILE_PATH +  basePackage.replace(StringUtil.DOT, StringUtil.BACKSLASH);
            String basePackageResourceFilePath =  RESOURCE_FILE_PATH;
            // 加载自定义模板
            for (String tempTemplateFilePath : tempTemplateFileMap.keySet()) {
                fileOutConfigList.add(new FileOutConfig(FILE_PREFIX + tempTemplateFilePath) {

                    @Override
                    public String outputFile(TableInfo tableInfo) {

                        String filename = tableInfo.getEntityName() + tempTemplateFileMap.get(tempTemplateFilePath).substring(0, tempTemplateFileMap.get(tempTemplateFilePath).length() - 4);

                        if(TemplatesEnums.type.ENTITY.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + TemplatesEnums.type.ENTITY.value() + StringUtil.BACKSLASH ) ) + basePackageSrcFilePath + StringUtil.BACKSLASH + TemplatesEnums.type.ENTITY.value() + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        } else if(TemplatesEnums.type.QUERY.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + TemplatesEnums.type.ENTITY.value() + StringUtil.BACKSLASH ) )  + basePackageSrcFilePath  + StringUtil.BACKSLASH + TemplatesEnums.type.ENTITY.value() + StringUtil.BACKSLASH +  VO_CONSTANT + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        } else if(TemplatesEnums.type.DAO.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + TemplatesEnums.type.DAO.value() + StringUtil.BACKSLASH ) ) + basePackageSrcFilePath  + StringUtil.BACKSLASH + TemplatesEnums.type.DAO.value() + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        } else if(TemplatesEnums.type.XML.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + WEB_CONSTANT + StringUtil.BACKSLASH ) ) + basePackageResourceFilePath  + StringUtil.BACKSLASH + XML_CONSTANT + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        } else if(TemplatesEnums.type.SERVICE.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + TemplatesEnums.type.SERVICE.value()  + StringUtil.BACKSLASH ) ) + basePackageSrcFilePath  + StringUtil.BACKSLASH + TemplatesEnums.type.SERVICE.value() + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        } else if(TemplatesEnums.type.SERVICEIMPL.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + TemplatesEnums.type.SERVICE.value() + StringUtil.BACKSLASH ) ) + basePackageSrcFilePath  + StringUtil.BACKSLASH + TemplatesEnums.type.SERVICE.value() + StringUtil.BACKSLASH + IMPL_CONSTANT + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        } else if(TemplatesEnums.type.CONTROLLER.value().equals(templateTypeMap.get(tempTemplateFilePath))){
                            String generatedFileStorePath = generatedFileStoreRootPath + (StringUtil.isEmpty(basePackageModuleName) ? StringUtil.EMPTY : (basePackageModuleName + StringUtil.MIDDLE + TemplatesEnums.type.CONTROLLER.value() + StringUtil.BACKSLASH ) ) + basePackageSrcFilePath  + StringUtil.BACKSLASH + TemplatesEnums.type.CONTROLLER.value() + StringUtil.BACKSLASH + filename;
                            generatedFileStorePathSet.add(generatedFileStorePath);
                            return generatedFileStorePath;
                        }
                        else {
                            return generatedFileStoreRootPath + filename;
                        }
                    }
                });
            }
            cfg.setFileOutConfigList(fileOutConfigList);
            autoGenerator.setCfg(cfg);
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setInclude(query.getTables().split(StringUtil.COMMA));
            autoGenerator.setStrategy(strategy);
            autoGenerator.setTemplateEngine(new BeetlTemplateEngine(tempTemplateFileRootPath));
            autoGenerator.setPackageInfo(pc);
            // 执行生成
            autoGenerator.execute();

            List<File> tiZipList = new ArrayList<>();
            // 将生成的文件打包
            for (String filePath: generatedFileStorePathSet) {
                File file = new File(filePath);
                tiZipList.add(file);
            }
            // 生成脚本文件
            String batGeneratedFileStorePath = generatedFileStoreRootPath + "/copy.bat";
            File file = new File(batGeneratedFileStorePath);
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(batGeneratedFileStorePath));
                out.write(query.getDirLocation());
                out.close();
                System.out.println("文件创建成功！");
            } catch (IOException e) {
                throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_GEN_BAT_SCRIPT_FAILED);
            }
            tiZipList.add(file);
            // 初始化压缩包文件路径
            String generatedFileStoreRootPathZip = SystemUtil.getStoreDir() + StringUtil.BACKSLASH +  genBatchUuid + StringUtil.BACKSLASH + ZIP_CONSTANT + StringUtil.BACKSLASH ;
            generatedFileStorePathZip = generatedFileStoreRootPathZip + query.getName() + StringUtil.DOT + ZIP_CONSTANT;
            File zipFile = new File(generatedFileStorePathZip);
            if (!zipFile.getParentFile().exists()){
                zipFile.getParentFile().mkdirs();
            }
            ZipUtil.compress(generatedFileStoreRootPath,zipFile);
            LOGGER.info(generatedFileStorePathZip);
        }
        return generatedFileStorePathZip;
    }

    /**
     * @description 生成临时文件
     * @param tempTemplateFileRootPath
     * @param templates
     * @return java.lang.String
     * @Author elvin
     * @Date 2021/5/12
     */
    private String genTempTemplateFile(String tempTemplateFileRootPath, Templates templates) throws IOException {
        String tempFilePath = tempTemplateFileRootPath + templates.getName();
        FileUtil.writeStringToFile(tempFilePath,templates.getContent());
        return tempFilePath;
    }


    private void validateParam(ConfiguresQuery query) {
        if(query.getId() == null){
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_ID_NULL);
        }
    }

    private void handleConfiguresTemplates(ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response) {

        // 清空原有模板关系
        ConfiguresTemplatesRelationExample configuresTemplatesRelationExample = new ConfiguresTemplatesRelationExample();
        ConfiguresTemplatesRelationExample.Criteria criteria = configuresTemplatesRelationExample.createCriteria();
        criteria.andConfiguresIdEqualTo(query.getId());
        configuresTemplatesRelationMapper.deleteByExample(configuresTemplatesRelationExample);
        // 插入新的关系
        String templateIds = query.getTemplateIds();
        List<String> templateIdListStr = StringUtil.parseStringToListComma(templateIds);
        if(!CollectionUtils.isEmpty(templateIdListStr)){
            for (String idStr : templateIdListStr) {
                ConfiguresTemplatesRelationQuery configuresTemplatesRelation = new ConfiguresTemplatesRelationQuery();
                configuresTemplatesRelation.setConfiguresId(query.getId());
                configuresTemplatesRelation.setTemplatesId(Integer.parseInt(idStr));
                configuresTemplatesRelationService.saveOrEdit(configuresTemplatesRelation,request,response);
            }
        }
    }

    /**
     * 模糊搜素
     * @param text 模糊的字符
     * @param fieldName 模糊字段名
     * @return FuzzyResponse
     */
    @Override
    public FuzzyResponse fuzzySearch(String text, String fieldName) {
        FuzzyVo fuzzyVo = new FuzzyVo();
        fuzzyVo.setText(text);
        fuzzyVo.setFieldName(fieldName);
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Configures"));
        return new FuzzyResponse.Builder().build(commonMapper.fuzzySearch(fuzzyVo));
    }

    /**
     * 保存记录
     * @param query  查询实体
     * @param request httpServletRequest
     * @param response
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT ,rollbackFor = Exception.class)
    public CommonResponse save(BaseQuery query, HttpServletRequest request, HttpServletResponse response) {

        configuresMapper.insert(this.assQueryForInsert((ConfiguresQuery)query,request,response));
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 更新记录
     * @param query
     * @param request
     * @param response
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.DEFAULT ,rollbackFor = Exception.class)
    public CommonResponse update(BaseQuery query, HttpServletRequest request, HttpServletResponse response) {
        ConfiguresQuery configuresQuery = ((ConfiguresQuery)query);

        ConfiguresExample example = new ConfiguresExample();
        ConfiguresExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(configuresQuery.getId());
        configuresQuery.setGmtModified(new Date());
        configuresMapper.updateByExampleSelective(configuresQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(ConfiguresQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Configures assQueryForInsert(ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(ConfiguresEnums.status.INIT.value());
        query.setGmtCreated(new Date());
        query.setGmtModified(new Date());
        return query;
    }

    /**
     * 组装更新状态实体
     * @param id
     * @param status
     * @param request
     * @param response
     * @return
     */
    private Configures assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        ConfiguresQuery infoQuery = new ConfiguresQuery();
        infoQuery.setId(id);
        infoQuery.setStatus(status);
        infoQuery.setGmtModified(new Date());
        return infoQuery;
    }

    /**
     * 组装分页参数
     * @param query
     * @return
     */
    private ConfiguresExample assExampleForList(ConfiguresQuery query) {
        ConfiguresExample example = new ConfiguresExample();
        ConfiguresExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(StringUtil.isNotEmpty(query.getName())){
            criteria.andNameEqualTo(query.getName());
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        // TODO
        if(StringUtil.isNotEmpty(query.getStates())){
            List list = new ArrayList();
            for (String state : query.getStates().split(",")) {
                list.add(Integer.parseInt(state));
            }
            criteria.andStatusIn(list);
        }
        criteria.andStatusNotEqualTo(StatusConstants.DELETED);
        example.setOrderByClause("gmt_modified desc");
        return example;
    }
}