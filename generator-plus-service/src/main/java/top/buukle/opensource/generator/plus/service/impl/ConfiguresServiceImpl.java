package top.buukle.opensource.generator.plus.service.impl;

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
import top.buukle.login.cube.session.SessionUtils;
import top.buukle.login.cube.session.UserDTO;
import top.buukle.login.cube.session.tenant.TenantHelper;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.call.PageResponse;
import top.buukle.opensource.generator.plus.commons.log.BaseLogger;
import top.buukle.opensource.generator.plus.commons.status.StatusConstants;
import top.buukle.opensource.generator.plus.dtvo.vo.templatesGroup.TemplatesGroupVO;
import top.buukle.opensource.generator.plus.entity.*;
import top.buukle.opensource.generator.plus.service.*;
import top.buukle.opensource.generator.plus.utils.DateUtil;
import top.buukle.opensource.generator.plus.utils.JsonUtil;
import top.buukle.opensource.generator.plus.utils.StringUtil;
import top.buukle.opensource.generator.plus.utils.SystemUtil;
import top.buukle.opensource.generator.plus.dao.ConfiguresMapper;
import top.buukle.opensource.generator.plus.dao.ConfiguresTemplatesRelationMapper;
import top.buukle.opensource.generator.plus.dtvo.dto.configures.ConfiguresQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.configures.ConfiguresUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.configuresExecute.ConfiguresExecuteQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.configuresExecute.ConfiguresExecuteUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.enums.ConfiguresEnums;
import top.buukle.opensource.generator.plus.dtvo.enums.ConfiguresExecuteEnums;
import top.buukle.opensource.generator.plus.dtvo.enums.TemplatesEnums;
import top.buukle.opensource.generator.plus.dtvo.vo.configures.ConfiguresVO;
import top.buukle.opensource.generator.plus.dtvo.vo.configuresExecute.ConfiguresExecuteVO;
import top.buukle.opensource.generator.plus.dtvo.vo.tables.TableVo;
import top.buukle.opensource.generator.plus.dtvo.vo.templates.TemplatesForConfigureEditVO;
import top.buukle.opensource.generator.plus.service.constants.SystemConstants;
import top.buukle.opensource.generator.plus.service.constants.SystemReturnEnum;
import top.buukle.opensource.generator.plus.service.engine.codes.MyBeetlTemplateEngine;
import top.buukle.opensource.generator.plus.service.engine.codes.MyTableInfo;
import top.buukle.opensource.generator.plus.service.exception.SystemException;
import top.buukle.opensource.generator.plus.service.util.DataBaseUtil;
import top.buukle.opensource.generator.plus.service.util.FileUtil;
import top.buukle.opensource.generator.plus.service.util.ZipUtil;
import top.buukle.opensource.generator.plus.service.util.enums.DatabaseType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
* @author elvin
* @description TemplatesService?????????
*/
@Service("configuresService")
public class ConfiguresServiceImpl extends ServiceImpl<ConfiguresMapper, Configures> implements ConfiguresService<Configures, ConfiguresVO, ConfiguresQueryDTO, ConfiguresUpdateDTO> {

    private static BaseLogger LOGGER = BaseLogger.getLogger(ConfiguresServiceImpl.class);

    private static final String GEN_TEMP_TEMPLATE_FILE = "/genTempTemplateFile/";
    private static final String TARGET_GENERATED_FILE = "/targetGeneratedFile/";
    private static final String FILE_PREFIX = "file:";
    private static final String ZIP_CONSTANT = "zip";

    @Autowired
    TemplatesService templatesService;

    @Autowired
    DatasourcesService datasourcesService;

    @Autowired
    ConfiguresTemplatesRelationMapper configuresTemplatesRelationMapper;

    @Autowired
    TemplatesGroupService templatesGroupService;

    @Autowired
    ConfiguresExecuteService<ConfiguresExecute, ConfiguresExecuteVO, ConfiguresExecuteQueryDTO, ConfiguresExecuteUpdateDTO> configuresExecuteService;

    @Autowired
    private Environment env;

    /**
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> add(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        // ??????DTO
        Configures configures = new Configures();
        BeanUtils.copyProperties(configuresUpdateDTO,configures);
        // ????????????
        this.savePre(configures);
        configures.setStatus(ConfiguresEnums.status.PUBLISHED.value());
        // ??????
        super.save(configures);
        // ??????
        ConfiguresVO configuresVO = new ConfiguresVO();
        BeanUtils.copyProperties(configures, configuresVO);
        return new CommonResponse.Builder().buildSuccess(configuresVO);
    }

    /**
     * @description ???or???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> addOrEdit(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        CommonResponse<ConfiguresVO> response;
        // ???
        if(configuresUpdateDTO.getId() == null){
            response = this.add(commonRequest);
            ConfiguresVO configuresVO = response.getBody();
            configuresUpdateDTO.setId(configuresVO.getId());
        }
        // ???
        else{
            response = this.updateById(commonRequest);
        }
        // ????????????
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
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> deleteById(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        // ????????????
        if(configuresUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ??????DTO
        Configures configures = new Configures();
        BeanUtils.copyProperties(configuresUpdateDTO,configures);
        this.updatePre(configures);
        configures.setStatus(StatusConstants.DELETED);
        // ??????
        super.updateById(configures);
        // ??????
        ConfiguresVO configuresVO = new ConfiguresVO();
        BeanUtils.copyProperties(configures, configuresVO);
        return new CommonResponse.Builder().buildSuccess(configuresVO);
    }

    /**
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> updateById(CommonRequest<ConfiguresUpdateDTO> commonRequest) {
        ConfiguresUpdateDTO configuresUpdateDTO = commonRequest.getBody();
        // ????????????
        if(configuresUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ??????DTO
        Configures configures = new Configures();
        BeanUtils.copyProperties(configuresUpdateDTO,configures);
        // ????????????
        this.updatePre(configures);
        // ??????
        super.updateById(configures);
        // ??????
        ConfiguresVO configuresVO = new ConfiguresVO();
        BeanUtils.copyProperties(configures, configuresVO);
        return new CommonResponse.Builder().buildSuccess(configuresVO);
    }

    /**
     * @description  ??? - ??????
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.Configures.ConfiguresQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresVO> getById(CommonRequest<ConfiguresQueryDTO> commonRequest) {
        ConfiguresQueryDTO configuresQueryDTO = commonRequest.getBody();
        // ????????????
        ConfiguresVO configuresVO = new ConfiguresVO();
        if(configuresQueryDTO == null || configuresQueryDTO.getId() == null){
            CommonResponse<ConfiguresVO> ConfiguresQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(configuresVO);
            return ConfiguresQueryVOCommonResponse;
        }
        // ????????????
        TenantHelper.startTenant("configures");
        Configures configuresDB = super.getById(configuresQueryDTO.getId());
        BeanUtils.copyProperties(configuresDB, configuresVO);
        /*??????????????????*/
        Datasources datasources = (Datasources) datasourcesService.getById(configuresDB.getDatasourcesId());
        configuresVO.setDatasourcesName(datasources.getName() + "(" + datasources.getId() + ")");
        Connection connection = null;
        // ??????????????????????????????????????????
        List<String> recordTables = StringUtil.parseStringToListComma(configuresVO.getTables());
        // ???????????????????????????????????????????????????
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
        // ??????????????????,????????????????????????????????????
        if(CollectionUtils.isEmpty(DBTables)){
            for (String tableName : recordTables) {
                TableVo tableVo = new TableVo();
                tableVo.setChecked(true);
                tableVo.setName(tableName);
                tableVoList.add(tableVo);
            }
        }
        // ?????????????????????????????????
        else{
            for (String dbTableName: DBTables) {
                TableVo tableVo = new TableVo();
                tableVo.setChecked(recordTables.contains(dbTableName));
                tableVo.setName(dbTableName);
                tableVoList.add(tableVo);
            }
        }
        configuresVO.setTableList(tableVoList);

        /* ????????????*/

        // ?????????????????????
        TemplatesGroup templatesGroup = (TemplatesGroup) templatesGroupService.getById(configuresDB.getTemplatesGroupId());
        if(templatesGroup == null){
            throw new SystemException(SystemReturnEnum.CONFIGURES_INFO_TEMPLATES_GROUP_NULL);
        }
        configuresVO.setTemplatesGroupName(templatesGroup.getName());
        // ?????????????????????
        QueryWrapper<ConfiguresTemplatesRelation> relationQueryWrapper = new QueryWrapper<>();
        relationQueryWrapper.eq("configures_id",configuresQueryDTO.getId());
        List<ConfiguresTemplatesRelation> configuresTemplatesRelations = configuresTemplatesRelationMapper.selectList(relationQueryWrapper);

        // ?????????????????????????????????????????????
        List<Integer> hasRelationTemplatesIdList = new ArrayList<>();
        for(ConfiguresTemplatesRelation configuresTemplatesRelation : configuresTemplatesRelations){
            hasRelationTemplatesIdList.add(configuresTemplatesRelation.getTemplatesId());
        }

        // ?????????????????????
        List<TemplatesForConfigureEditVO> templatesResult = new ArrayList<>();
        List<Integer> templateIdsResult = new ArrayList<>();

        // ???????????????
        QueryWrapper<Templates> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",3);
        queryWrapper.eq("templates_group_id",configuresDB.getTemplatesGroupId());
        List<Templates> templatesAll = templatesService.list(queryWrapper);
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
     * @description ??? - ??????
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.Configures.ConfiguresQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<ConfiguresVO> getPage(CommonRequest<ConfiguresQueryDTO> commonRequest) {
        // ??????DTO
        ConfiguresQueryDTO ConfiguresQueryDTO = commonRequest.getBody();
        Configures Configures = new Configures();
        BeanUtils.copyProperties(ConfiguresQueryDTO,Configures);
        // ??????
        QueryWrapper<Configures> queryWrapper = this.assPageParam(ConfiguresQueryDTO);
        // ??????
        PageHelper.startPage(ConfiguresQueryDTO.getPageNo(),ConfiguresQueryDTO.getPageSize());
        TenantHelper.startTenant("configures");
        List<Configures> list = super.list(queryWrapper);
        PageInfo<Configures> pageInfo = new PageInfo<>(list);
        // ??????
        List<ConfiguresVO> queryVOList = new ArrayList<>();
        for (Configures ConfiguresDB : list) {
            ConfiguresVO ConfiguresVO = new ConfiguresVO();
            BeanUtils.copyProperties(ConfiguresDB, ConfiguresVO);
            queryVOList.add(ConfiguresVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description ??????????????????
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
        // ??????????????? ...
        return queryWrapper;
    }

    /**
     * @description ??? - ?????????
     * @param Configures
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(Configures Configures) {
        Date date = new Date();

        UserDTO operator = SessionUtils.getOperator();

        Configures.setGmtCreated(date);
        Configures.setCreator(operator.getUsername());
        Configures.setCreatorCode(operator.getUserId());
        Configures.setTenantId(Integer.parseInt(StringUtil.isEmpty(operator.getTenantId())?"-1":operator.getTenantId()));
        Configures.setGmtModified(date);

        Configures.setModifier(operator.getUsername());
        Configures.setModifierCode(operator.getUserId());
        Configures.setStatus(ConfiguresEnums.status.INIT.value());

    }

    /**
     * @description ??? - ?????????
     * @param Configures
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(Configures Configures) {

        Date date = new Date();

        UserDTO operator = SessionUtils.getOperator();

        Configures.setGmtModified(date);
        Configures.setModifier(operator.getUsername());
        Configures.setModifierCode(operator.getUserId());

    }

    /**
     * @description ??????
     * @param commonRequest
     * @return top.buukle.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/4
     */
    @Override
    public CommonResponse<Boolean> gen(CommonRequest<ConfiguresQueryDTO> commonRequest) {
        ConfiguresQueryDTO configuresQueryDTO = commonRequest.getBody();
        // ????????????
        validateGenParam(configuresQueryDTO);
        // ??????????????????
        Configures  configures= super.getById(configuresQueryDTO.getId());
        // ?????????????????????
        ConfiguresExecuteUpdateDTO configuresExecuteUpdateDTO = new ConfiguresExecuteUpdateDTO();
        BeanUtils.copyProperties(configures,configuresExecuteUpdateDTO);
        configuresExecuteUpdateDTO.setId(null);
        configuresExecuteUpdateDTO.setConfiguresId(configures.getId());
        // ?????????????????????????????????
        Datasources datasourcesForExecute = (Datasources) datasourcesService.getById(configures.getDatasourcesId());
        configuresExecuteUpdateDTO.setDatabasesInfo(JsonUtil.toJSONString(datasourcesForExecute));
        // ????????????????????????????????????
        QueryWrapper<ConfiguresTemplatesRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("configures_id",configures.getId());
        List<ConfiguresTemplatesRelation> configuresTemplatesRelations = configuresTemplatesRelationMapper.selectList(queryWrapper);
        List<Integer> ids = new ArrayList<>();

        for (ConfiguresTemplatesRelation configuresTemplatesRelation: configuresTemplatesRelations) {
            ids.add(configuresTemplatesRelation.getTemplatesId());
        }
        QueryWrapper<Templates> templatesQueryWrapper = new QueryWrapper<>();
        templatesQueryWrapper.in("id",ids);
        templatesQueryWrapper.eq("status", TemplatesEnums.status.PUBLISHED.value());
        List<Templates> templatesList = templatesService.list(templatesQueryWrapper);
        // ??????????????????
        configuresExecuteUpdateDTO.setTemplatesInfo(JsonUtil.toJSONString(templatesList));
        CommonRequest<ConfiguresExecuteUpdateDTO> configuresExecuteUpdateDTOCommonRequest = new CommonRequest<>();
        configuresExecuteUpdateDTOCommonRequest.setHead(commonRequest.getHead());
        configuresExecuteUpdateDTOCommonRequest.setBody(configuresExecuteUpdateDTO);
        CommonResponse<ConfiguresExecuteVO> configuresExecuteVOCommonResponse = configuresExecuteService.add(configuresExecuteUpdateDTOCommonRequest);
        ConfiguresExecuteVO configuresExecuteVO = configuresExecuteVOCommonResponse.getBody();
        // ????????????????????????????????????
        configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.PUBLISHED.value(),ConfiguresExecuteEnums.status.EXECUTING.value(),configuresExecuteVO.getId());
        String generatedFileStorePathZip;
        try {
            generatedFileStorePathZip = this.doGen(configures, configuresTemplatesRelations);
        } catch (Exception e) {
            e.printStackTrace();
            // ???????????????????????????????????????
            configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_FAILED.value(),configuresExecuteVO.getId());
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_FAILED);
        }
        if(StringUtil.isEmpty(generatedFileStorePathZip)){
            // ???????????????????????????????????????
            configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_FAILED.value(),configuresExecuteVO.getId());
            throw new SystemException(SystemReturnEnum.GEN_CONFIGURES_FAILED);
        }

        // ??????????????????zip?????????????????????????????????,????????????????????????????????????
        ConfiguresExecute configuresExecuteQueryForUpdate = new ConfiguresExecute();
        configuresExecuteQueryForUpdate.setId(configuresExecuteVO.getId());
        String downUrl = generatedFileStorePathZip.replaceFirst(SystemUtil.getStoreDir(), SystemConstants.SOFT_CONTEXT_PATH + "upload/temp");
        configuresExecuteQueryForUpdate.setZipDownUrl(downUrl);
        configuresExecuteService.updateById(configuresExecuteQueryForUpdate);
        // ???????????????????????????????????????
        configuresExecuteService.updateStatus(ConfiguresExecuteEnums.status.EXECUTING.value(),ConfiguresExecuteEnums.status.EXECUTE_SUCCESS.value(),configuresExecuteVO.getId());
        return new CommonResponse.Builder().buildSuccess();
    }

    private String doGen(Configures configures, List<ConfiguresTemplatesRelation> configuresTemplatesRelations) throws IOException {

        String generatedFileStorePathZip = null;
        // ???????????????
        AutoGenerator autoGenerator = new AutoGenerator();
        // ????????????
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor(SessionUtils.getOperator().getUsername());
        globalConfig.setOpen(false);
        // ???????????? Swagger2 ??????
        globalConfig.setSwagger2(true);
        globalConfig.setDateType(DateType.ONLY_DATE);
        // ???????????????
        Datasources datasources  = (Datasources) datasourcesService.getById(configures.getDatasourcesId());
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(datasources.getUrl());
        dataSourceConfig.setDriverName(DatabaseType.MySQL.getDriverClazzName());
        dataSourceConfig.setUsername(datasources.getUsername());
        dataSourceConfig.setPassword(datasources.getPassword());
        autoGenerator.setDataSource(dataSourceConfig);

        // ?????????
        PackageConfig pc = new PackageConfig();
        pc.setParent(StringUtil.EMPTY);
        // ???????????????
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        };
        /* ???????????????*/
        // ??????uuid
        String genBatchUuid = UUID.randomUUID().toString().replace( StringUtil.MIDDLE, StringUtil.EMPTY);
        // ?????????????????????
        TemplatesGroup templatesGroup = (TemplatesGroup) templatesGroupService.getById(configures.getTemplatesGroupId());
        if(templatesGroup == null){
            throw new SystemException(SystemReturnEnum.CONFIGURES_INFO_TEMPLATES_GROUP_NULL);
        }
        // ??????????????????????????????
        if(!CollectionUtils.isEmpty(configuresTemplatesRelations)){
            // ??????????????????????????? ???????????? ???????????????
            Map<String,Templates> tempTemplateFileMap = new HashMap<>();
            // ????????????????????????????????????
            String tempTemplateFileRootPath = SystemUtil.getStoreDir() + StringUtil.BACKSLASH + genBatchUuid + GEN_TEMP_TEMPLATE_FILE;
            // ?????????????????????
            Templates templates;
            //????????????????????????,???????????????????????????????????????
            TemplateConfig templateConfig = new TemplateConfig();
            templateConfig.disable(TemplateType.CONTROLLER,
                    TemplateType.ENTITY,
                    TemplateType.MAPPER,
                    TemplateType.SERVICE,
                    TemplateType.XML);
            for (ConfiguresTemplatesRelation configuresTemplatesRelation : configuresTemplatesRelations) {
                templates = (Templates) templatesService.getById(configuresTemplatesRelation.getTemplatesId());
                // ????????????????????????
                String tempTemplateFilePath = this.genTempTemplateFile(tempTemplateFileRootPath,templates);
                tempTemplateFileMap.put(tempTemplateFilePath,templates);
            }
            autoGenerator.setTemplate(templateConfig);

            //??????????????????
            globalConfig.setOutputDir(SystemUtil.getStoreDir() + StringUtil.BACKSLASH + genBatchUuid);
            autoGenerator.setGlobalConfig(globalConfig);
            // ????????????????????????
            List<FileOutConfig> fileOutConfigList = new ArrayList<>();

            // ??????????????????????????????????????????????????????
            String generatedFileStoreRootPath = SystemUtil.getStoreDir() + StringUtil.BACKSLASH +  genBatchUuid + TARGET_GENERATED_FILE;
            // ?????????????????????????????????????????????????????????
            Set<String> generatedFileStorePathSet = new HashSet<>();
            // ?????????????????????
            for (String tempTemplateFilePath : tempTemplateFileMap.keySet()) {
                fileOutConfigList.add(new FileOutConfig(FILE_PREFIX + tempTemplateFilePath) {

                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // ??????????????????????????????????????????
                        HashMap<String,String> templateGroupParamsMap = new HashMap<>();
                        Templates templatesToGen = tempTemplateFileMap.get(tempTemplateFilePath);
                        // ?????????????????????
                        String projectPath = templatesToGen.getPath();
                        boolean openTablePath = TemplatesEnums.openTablePath.OPEN.value().equals(templatesToGen.getOpenTablePath());
                        projectPath = StringUtil.isEmpty(projectPath) ? StringUtil.EMPTY : projectPath + StringUtil.BACKSLASH;
                        projectPath = openTablePath ?
                                projectPath + StringUtil.BACKSLASH +tableInfo.getEntityPath()+ StringUtil.BACKSLASH
                                :
                                projectPath;
                        // ???????????????
                        String name = templatesToGen.getName();
                        String[] split = name.split("\\.");
                        String front = split[0];
                        String filename = null;
                        if(TemplatesEnums.addNameSuffix.TABLE_BIG_CALM.value().equals(templatesToGen.getAddNameSuffix())){
                            filename = tableInfo.getEntityName() ;
                        }
                        if(TemplatesEnums.addNameSuffix.TEMPLATE_FRONT_MIDDLE.value().equals(templatesToGen.getAddNameSuffix())){
                            filename = front;
                        }
                        if(TemplatesEnums.addNameSuffix.TABLE_BIG_CALM_PLUS_TEMPLATE_FRONT_MIDDLE.value().equals(templatesToGen.getAddNameSuffix())){
                            filename =  tableInfo.getEntityName() + front;
                        }
                        filename = filename + StringUtil.DOT + split[split.length - 2];

                        if(tableInfo instanceof MyTableInfo){
                            MyTableInfo myTableInfo = (MyTableInfo) tableInfo;
                            // ???????????????????????????
                            String packageInfo = templatesToGen.getPackageInfo();
                            packageInfo = packageInfo + (openTablePath ? StringUtil.DOT + tableInfo.getEntityPath() : StringUtil.EMPTY);
                            myTableInfo.setPackageInfo(packageInfo);
                            String params = templatesGroup.getParams();
                            List<TemplatesGroupVO.Param> paramList = JsonUtil.parseArray(params, TemplatesGroupVO.Param.class);
                            HashMap<String,String> hashMap = new HashMap<>();
                            for (TemplatesGroupVO.Param param : paramList) {
                                hashMap.put(param.getName(),param.getValue());
                            }
                            myTableInfo.setGroupParams(hashMap);
                        }
                        // ????????????path
                        String generatedFileStorePath = generatedFileStoreRootPath  + projectPath + filename;
                        generatedFileStorePathSet.add(generatedFileStorePath);
                        return generatedFileStorePath;
                    }
                });
            }
            cfg.setFileOutConfigList(fileOutConfigList);
            autoGenerator.setCfg(cfg);
            // ????????????
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setInclude(configures.getTables().split(StringUtil.COMMA));
            autoGenerator.setStrategy(strategy);
            autoGenerator.setTemplateEngine(new MyBeetlTemplateEngine(tempTemplateFileRootPath));
            autoGenerator.setPackageInfo(pc);
            // ????????????
            autoGenerator.execute();

            List<File> tiZipList = new ArrayList<>();
            // ????????????????????????
            for (String filePath: generatedFileStorePathSet) {
                File file = new File(filePath);
                tiZipList.add(file);
            }
            // ??????????????????
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
            // ??????????????????????????????
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
     * @description ??????????????????
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
