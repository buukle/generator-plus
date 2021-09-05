package top.buukle.opensource.arche.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.business.base.commons.call.CommonRequest;
import top.buukle.business.base.commons.call.CommonResponse;
import top.buukle.business.base.commons.call.PageResponse;
import top.buukle.business.base.commons.log.BaseLogger;
import top.buukle.business.base.commons.session.SessionUtils;
import top.buukle.business.base.commons.session.UserDO;
import top.buukle.business.base.commons.status.StatusConstants;
import top.buukle.opensource.arche.generator.dao.ConfiguresMapper;
import top.buukle.opensource.arche.generator.dao.ConfiguresTemplatesRelationMapper;
import top.buukle.opensource.arche.generator.dos.dto.configures.ConfiguresQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.configures.ConfiguresUpdateDTO;
import top.buukle.opensource.arche.generator.dos.dto.configuresExecute.ConfiguresExecuteQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.configuresExecute.ConfiguresExecuteUpdateDTO;
import top.buukle.opensource.arche.generator.dos.enums.ConfiguresEnums;
import top.buukle.opensource.arche.generator.dos.enums.ConfiguresExecuteEnums;
import top.buukle.opensource.arche.generator.dos.enums.TemplatesEnums;
import top.buukle.opensource.arche.generator.dos.vo.configures.ConfiguresVO;
import top.buukle.opensource.arche.generator.dos.vo.configuresExecute.ConfiguresExecuteVO;
import top.buukle.opensource.arche.generator.dos.vo.tables.TableVo;
import top.buukle.opensource.arche.generator.dos.vo.templates.TemplatesForConfigureEditVO;
import top.buukle.opensource.arche.generator.entity.*;
import top.buukle.opensource.arche.generator.service.ConfiguresExecuteService;
import top.buukle.opensource.arche.generator.service.ConfiguresService;
import top.buukle.opensource.arche.generator.service.DatasourcesService;
import top.buukle.opensource.arche.generator.service.TemplatesService;
import top.buukle.opensource.arche.generator.service.constants.SystemReturnEnum;
import top.buukle.opensource.arche.generator.service.engine.MyBeetlTemplateEngine;
import top.buukle.opensource.arche.generator.service.engine.MyTableInfo;
import top.buukle.opensource.arche.generator.service.exception.SystemException;
import top.buukle.opensource.arche.generator.service.util.DataBaseUtil;
import top.buukle.opensource.arche.generator.service.util.FileUtil;
import top.buukle.opensource.arche.generator.service.util.ZipUtil;
import top.buukle.opensource.arche.generator.service.util.enums.DatabaseType;
import top.buukle.business.base.utils.DateUtil;
import top.buukle.business.base.utils.JsonUtil;
import top.buukle.business.base.utils.StringUtil;
import top.buukle.business.base.utils.SystemUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
* @author elvin
* @description TemplatesService实现类
*/
@Service("configuresService")
public class ConfiguresServiceImpl extends ServiceImpl<ConfiguresMapper, Configures> implements ConfiguresService<Configures, ConfiguresVO, ConfiguresQueryDTO, ConfiguresUpdateDTO> {

    private static BaseLogger LOGGER = BaseLogger.getLogger(ConfiguresServiceImpl.class);

    private static final String GEN_TEMP_TEMPLATE_FILE = "/genTempTemplateFile/";
    private static final String TARGET_GENERATED_FILE = "/targetGeneratedFile/";
    private static final String RESOURCE_FILE_PATH = "src/main/resources/";
    private static final String FILE_PREFIX = "file:";
    private static final String IMPL_CONSTANT = "impl";
    private static final String WEB_CONSTANT = "web";
    private static final String VO_CONSTANT = "vo";
    private static final String XML_CONSTANT = "config/mapper";
    private static final String ZIP_CONSTANT = "zip";

    @Autowired
    TemplatesService templatesService;

    @Autowired
    DatasourcesService datasourcesService;

    @Autowired
    ConfiguresTemplatesRelationMapper configuresTemplatesRelationMapper;

    @Autowired
    ConfiguresExecuteService<ConfiguresExecute, ConfiguresExecuteVO, ConfiguresExecuteQueryDTO, ConfiguresExecuteUpdateDTO> configuresExecuteService;

    @Autowired
    private Environment env;

    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> add(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        // 转换DTO
        Configures configures = new Configures();
        BeanUtils.copyProperties(configuresUpdateDTO,configures);
        // 初始字段
        this.savePre(configures);
        configures.setStatus(ConfiguresEnums.status.PUBLISHED.value());
        // 落库
        super.save(configures);
        // 返回
        ConfiguresVO configuresVO = new ConfiguresVO();
        BeanUtils.copyProperties(configures, configuresVO);
        return new CommonResponse.Builder().buildSuccess(configuresVO);
    }

    /**
     * @description 增or改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> addOrEdit(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        CommonResponse<ConfiguresVO> response;
        // 增
        if(configuresUpdateDTO.getId() == null){
            response = this.add(commonRequest);
        }
        // 改
        else{
            response = this.updateById(commonRequest);
        }
        // 模板关系
        this.removeAndInsertTemplateRelation(configuresUpdateDTO);
        return response;
    }

    private void removeAndInsertTemplateRelation(ConfiguresUpdateDTO configuresUpdateDTO) {

        QueryWrapper<ConfiguresTemplatesRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("configures_Id",configuresUpdateDTO.getId());
        configuresTemplatesRelationMapper.delete(queryWrapper);

        String templateIds = configuresUpdateDTO.getTemplateIds();
        List<String> templateIdListStr = StringUtil.parseStringToListComma(templateIds);
        if(!CollectionUtils.isEmpty(templateIdListStr)){
            for (String idStr : templateIdListStr) {
                ConfiguresTemplatesRelation configuresTemplatesRelation = new ConfiguresTemplatesRelation();
                configuresTemplatesRelation.setConfiguresId(configuresUpdateDTO.getId());
                configuresTemplatesRelation.setTemplatesId(Integer.parseInt(idStr));
                configuresTemplatesRelationMapper.insert(configuresTemplatesRelation);
            }
        }
    }


    /**
     * @description 删
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> deleteById(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(configuresUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Configures configures = new Configures();
        BeanUtils.copyProperties(configuresUpdateDTO,configures);
        this.updatePre(configures);
        configures.setStatus(StatusConstants.DELETED);
        // 落库
        super.updateById(configures);
        // 返回
        ConfiguresVO configuresVO = new ConfiguresVO();
        BeanUtils.copyProperties(configures, configuresVO);
        return new CommonResponse.Builder().buildSuccess(configuresVO);
    }

    /**
     * @description 改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> updateById(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(configuresUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Configures configures = new Configures();
        BeanUtils.copyProperties(configuresUpdateDTO,configures);
        // 更新字段
        this.updatePre(configures);
        // 落库
        super.updateById(configures);
        // 返回
        ConfiguresVO configuresVO = new ConfiguresVO();
        BeanUtils.copyProperties(configures, configuresVO);
        return new CommonResponse.Builder().buildSuccess(configuresVO);
    }

    /**
     * @description  查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.Configures.ConfiguresQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> getById(CommonRequest<ConfiguresQueryDTO> commonRequest) {
        ConfiguresQueryDTO configuresQueryDTO = commonRequest.getBody();
        // 组织响应
        ConfiguresVO configuresVO = new ConfiguresVO();
        // 查询模板表
        QueryWrapper<Templates> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",3);
        List<Templates> templatesAll = templatesService.list(queryWrapper);
        if(configuresQueryDTO.getId() == null){
            List<TemplatesForConfigureEditVO> templatesResult = new ArrayList<>();
            // 加工返回结构
            for(Templates templates : templatesAll){
                TemplatesForConfigureEditVO templatesQueryVo = new TemplatesForConfigureEditVO();
                BeanUtils.copyProperties(templates,templatesQueryVo);
                templatesQueryVo.setChecked(false);
                templatesResult.add(templatesQueryVo);
            }
            configuresVO.setTemplatesList(templatesResult);
            CommonResponse<ConfiguresVO> ConfiguresQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(configuresVO);
            return ConfiguresQueryVOCommonResponse;
        }
        // 执行查询
        Configures configuresDB = super.getById(configuresQueryDTO.getId());
        BeanUtils.copyProperties(configuresDB, configuresVO);
        /*处理表名列表*/
        Datasources datasources = (Datasources) datasourcesService.getById(configuresDB.getDatasourcesId());
        configuresVO.setDatasourcesName(datasources.getName() + "(" + datasources.getId() + ")");
        Connection connection = null;
        // 初始化配置表中记录的表名集合
        List<String> recordTables = StringUtil.parseStringToListComma(configuresVO.getTables());
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
        configuresVO.setTableList(tableVoList);

        /* 模板处理*/

        // 查询模板关系表
        QueryWrapper<ConfiguresTemplatesRelation> relationQueryWrapper = new QueryWrapper<>();
        relationQueryWrapper.eq("configures_id",configuresQueryDTO.getId());
        List<ConfiguresTemplatesRelation> configuresTemplatesRelations = configuresTemplatesRelationMapper.selectList(relationQueryWrapper);

        // 初始化一个集合用来查询是否存在
        List<Integer> hasRelationTemplatesIdList = new ArrayList<>();
        for(ConfiguresTemplatesRelation configuresTemplatesRelation : configuresTemplatesRelations){
            hasRelationTemplatesIdList.add(configuresTemplatesRelation.getTemplatesId());
        }

        // 初始化返回结构
        List<TemplatesForConfigureEditVO> templatesResult = new ArrayList<>();
        List<Integer> templateIdsResult = new ArrayList<>();

        // 加工返回结构
        for(Templates templates : templatesAll){
            TemplatesForConfigureEditVO templatesQuery = new TemplatesForConfigureEditVO();
            BeanUtils.copyProperties(templates,templatesQuery);
            boolean contains = hasRelationTemplatesIdList.contains(templates.getId());
            templatesQuery.setChecked(contains);
            templatesResult.add(templatesQuery);
            if(contains){
                templateIdsResult.add(templates.getId());
            }
        }
        configuresVO.setTemplatesList(templatesResult);
        configuresVO.setTemplateIds(StringUtil.IntegerListToString(templateIdsResult));

        CommonResponse<ConfiguresVO> ConfiguresQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(configuresVO);
        return ConfiguresQueryVOCommonResponse;
    }

    /**
     * @description 查 - 分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.Configures.ConfiguresQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<ConfiguresVO> getPage(CommonRequest<ConfiguresQueryDTO> commonRequest) {
        // 转换DTO
        ConfiguresQueryDTO ConfiguresQueryDTO = commonRequest.getBody();
        Configures Configures = new Configures();
        BeanUtils.copyProperties(ConfiguresQueryDTO,Configures);
        // 条件
        QueryWrapper<Configures> queryWrapper = this.assPageParam(ConfiguresQueryDTO);
        // 查询
        PageHelper.startPage(ConfiguresQueryDTO.getPageNo(),ConfiguresQueryDTO.getPageSize());
        List<Configures> list = super.list(queryWrapper);
        PageInfo<Configures> pageInfo = new PageInfo<>(list);
        // 分页
        List<ConfiguresVO> queryVOList = new ArrayList<>();
        for (Configures ConfiguresDB : list) {
            ConfiguresVO ConfiguresVO = new ConfiguresVO();
            BeanUtils.copyProperties(ConfiguresDB, ConfiguresVO);
            queryVOList.add(ConfiguresVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description 组装分页条件
     * @param ConfiguresQueryDTO
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<top.buukle.generator.entity.model.Configures>
     * @Author 17600
     * @Date 2021/9/2
     */
    private QueryWrapper<Configures> assPageParam( ConfiguresQueryDTO ConfiguresQueryDTO) {
        QueryWrapper<Configures> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(ConfiguresQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(ConfiguresQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(ConfiguresQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(ConfiguresQueryDTO.getStartTime()));
        }
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        // 可按需扩展 ...
        return queryWrapper;
    }

    /**
     * @description 增 - 初始化
     * @param Configures
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(Configures Configures) {
        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        Configures.setGmtCreated(date);
        Configures.setCreator(operator.getUsername());
        Configures.setCreatorCode(operator.getUserId());
        Configures.setCreatorDeptId(Integer.parseInt(StringUtil.isEmpty(operator.getDeptId())?"-1":operator.getDeptId()));
        Configures.setGmtModified(date);

        Configures.setModifier(operator.getUsername());
        Configures.setModifierCode(operator.getUserId());
        Configures.setStatus(ConfiguresEnums.status.INIT.value());

    }

    /**
     * @description 改 - 初始化
     * @param Configures
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(Configures Configures) {

        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        Configures.setGmtModified(date);
        Configures.setModifier(operator.getUsername());
        Configures.setModifierCode(operator.getUserId());

    }

    /**
     * @description 生成
     * @param commonRequest
     * @return top.buukle.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/4
     */
    @Override
    public CommonResponse<Boolean> gen(CommonRequest<ConfiguresQueryDTO> commonRequest) {
        ConfiguresQueryDTO configuresQueryDTO = commonRequest.getBody();
        // 校验参数
        validateGenParam(configuresQueryDTO);
        // 查询配置记录
        Configures  configures= super.getById(configuresQueryDTO.getId());
        // 初始化日志记录
        ConfiguresExecuteUpdateDTO configuresExecuteUpdateDTO = new ConfiguresExecuteUpdateDTO();
        BeanUtils.copyProperties(configures,configuresExecuteUpdateDTO);
        configuresExecuteUpdateDTO.setId(null);
        configuresExecuteUpdateDTO.setConfiguresId(configures.getId());
        // 初始化日志记录连接信息
        Datasources datasourcesForExecute = (Datasources) datasourcesService.getById(configures.getDatasourcesId());
        configuresExecuteUpdateDTO.setDatabasesInfo(JsonUtil.toJSONString(datasourcesForExecute));
        // 初始化日志记录模板关系表
        QueryWrapper<ConfiguresTemplatesRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("configures_id",configures.getId());
        List<ConfiguresTemplatesRelation> configuresTemplatesRelations = configuresTemplatesRelationMapper.selectList(queryWrapper);
        List<Templates> templatesList = new ArrayList<>();
        for (ConfiguresTemplatesRelation configuresTemplatesRelation: configuresTemplatesRelations) {
            Templates templates = (Templates) templatesService.getById(configuresTemplatesRelation.getTemplatesId());
            templatesList.add(templates);
        }
        // 插入日志记录
        configuresExecuteUpdateDTO.setTemplatesInfo(JsonUtil.toJSONString(templatesList));
        CommonRequest<ConfiguresExecuteUpdateDTO> configuresExecuteUpdateDTOCommonRequest = new CommonRequest<>();
        configuresExecuteUpdateDTOCommonRequest.setHead(commonRequest.getHead());
        configuresExecuteUpdateDTOCommonRequest.setBody(configuresExecuteUpdateDTO);
        CommonResponse<ConfiguresExecuteVO> configuresExecuteVOCommonResponse = configuresExecuteService.add(configuresExecuteUpdateDTOCommonRequest);
        ConfiguresExecuteVO configuresExecuteVO = configuresExecuteVOCommonResponse.getBody();
        // 更新执行记录状态为执行中
        configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.PUBLISHED.value(),ConfiguresExecuteEnums.status.EXECUTING.value(),configuresExecuteVO.getId());
        String generatedFileStorePathZip;
        try {
            generatedFileStorePathZip = this.doGen(configures, configuresTemplatesRelations);
        } catch (Exception e) {
            e.printStackTrace();
            // 更新执行记录状态为执行失败
            configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_FAILED.value(),configuresExecuteVO.getId());
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_FAILED);
        }
        if(StringUtil.isEmpty(generatedFileStorePathZip)){
            // 更新执行记录状态为执行失败
            configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_FAILED.value(),configuresExecuteVO.getId());
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_FAILED);
        }

        // 将本地临时的zip文件映射到静态资源路径,并更新日志记录的下载地址
        ConfiguresExecute configuresExecuteQueryForUpdate = new ConfiguresExecute();
        configuresExecuteQueryForUpdate.setId(configuresExecuteVO.getId());
        String downUrl;
        if(SystemUtil.isWindows()){
            downUrl = generatedFileStorePathZip.replaceFirst("D://file",  env.getProperty("server.servlet.context-path") +  "/upload");
        }else{
            downUrl = generatedFileStorePathZip.replaceFirst("/opt",  env.getProperty("server.servlet.context-path") +  "/upload");
        }
        configuresExecuteQueryForUpdate.setZipDownUrl(downUrl);
        configuresExecuteService.updateById(configuresExecuteQueryForUpdate);
        // 更新执行记录状态为执行成功
        configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_SUCCESS.value(),configuresExecuteVO.getId());
        return new CommonResponse.Builder().buildSuccess();
    }

    private String doGen(Configures configures, List<ConfiguresTemplatesRelation> configuresTemplatesRelations) throws IOException {

        String generatedFileStorePathZip = null;
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor(SessionUtils.getOperator().getUsername());
        globalConfig.setOpen(false);
        // 实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        globalConfig.setDateType(DateType.ONLY_DATE);
        // 数据源配置
        Datasources datasources  = (Datasources) datasourcesService.getById(configures.getDatasourcesId());
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(datasources.getUrl());
        dataSourceConfig.setDriverName(DatabaseType.MySQL.getDriverClazzName());
        dataSourceConfig.setUsername(datasources.getUsername());
        dataSourceConfig.setPassword(datasources.getPassword());
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(StringUtil.EMPTY);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        };
        /* 自定义输出*/
        // 批次uuid
        String genBatchUuid = UUID.randomUUID().toString().replace( StringUtil.MIDDLE, StringUtil.EMPTY);
        // 按照模板信息进行生成
        if(!CollectionUtils.isEmpty(configuresTemplatesRelations)){
            // 初始化临时生成模板 的路径和 模板的映射
            Map<String,Templates> tempTemplateFileMap = new HashMap<>();
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
                templates = (Templates) templatesService.getById(configuresTemplatesRelation.getTemplatesId());
                // 生成临时模板文件
                String tempTemplateFilePath = this.genTempTemplateFile(tempTemplateFileRootPath,templates);
                tempTemplateFileMap.put(tempTemplateFilePath,templates);
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
            // 加载自定义模板
            for (String tempTemplateFilePath : tempTemplateFileMap.keySet()) {
                fileOutConfigList.add(new FileOutConfig(FILE_PREFIX + tempTemplateFilePath) {

                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        Templates templatesToGen = tempTemplateFileMap.get(tempTemplateFilePath);
                        // 处理工程内路径
                        String projectPath = templatesToGen.getPath();
                        projectPath = StringUtil.isEmpty(projectPath) ? StringUtil.EMPTY : projectPath + StringUtil.BACKSLASH;
                        projectPath = TemplatesEnums.openTablePath.OPEN.value().equals(templatesToGen.getOpenTablePath()) ?
                                projectPath + StringUtil.BACKSLASH +tableInfo.getEntityPath()+ StringUtil.BACKSLASH
                                :
                                projectPath;
                        // 处理文件名
                        String name = templatesToGen.getName();
                        String[] split = name.split("\\.");
                        String filename = tableInfo.getEntityName() + (
                                TemplatesEnums.addNameSuffix.OPEN.value().equals(templatesToGen.getAddNameSuffix()) ?
                                        split[0] : StringUtil.EMPTY
                                );
                        filename = filename + StringUtil.DOT + split[split.length - 2];

                        if(tableInfo instanceof MyTableInfo){
                            MyTableInfo myTableInfo = (MyTableInfo) tableInfo;
                            // 处理文件内部的包名
                            myTableInfo.setPackageInfo(templatesToGen.getPackageInfo());
                        }
                        // 处理文件path
                        String generatedFileStorePath = generatedFileStoreRootPath  + projectPath + filename;
                        generatedFileStorePathSet.add(generatedFileStorePath);
                        return generatedFileStorePath;
                    }
                });
            }
            cfg.setFileOutConfigList(fileOutConfigList);
            autoGenerator.setCfg(cfg);
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setInclude(configures.getTables().split(StringUtil.COMMA));
            autoGenerator.setStrategy(strategy);
            autoGenerator.setTemplateEngine(new MyBeetlTemplateEngine(tempTemplateFileRootPath));
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
            String batGeneratedFileStorePath = generatedFileStoreRootPath + "copy.bat";
            File file = new File(batGeneratedFileStorePath);
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(batGeneratedFileStorePath));
                out.write(configures.getDirLocation());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_GEN_BAT_SCRIPT_FAILED);
            }
            tiZipList.add(file);
            // 初始化压缩包文件路径
            String generatedFileStoreRootPathZip = SystemUtil.getStoreDir() + StringUtil.BACKSLASH +  genBatchUuid + StringUtil.BACKSLASH + ZIP_CONSTANT + StringUtil.BACKSLASH ;
            generatedFileStorePathZip = generatedFileStoreRootPathZip + configures.getName() + StringUtil.DOT + ZIP_CONSTANT;
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

    private void validateGenParam(ConfiguresQueryDTO configuresQueryDTO) {
        if(configuresQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_ID_NULL);
        }

    }
}