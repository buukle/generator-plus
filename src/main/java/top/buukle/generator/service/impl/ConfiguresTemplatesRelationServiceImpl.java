package top.buukle.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.commons.call.vo.FuzzyVo;
import top.buukle.generator.commons.mvc.BaseQuery;
import top.buukle.generator.commons.status.StatusConstants;
import top.buukle.generator.dao.CommonMapper;
import top.buukle.generator.dao.ConfiguresTemplatesRelationMapper;
import top.buukle.generator.entity.ConfiguresTemplatesRelation;
import top.buukle.generator.entity.ConfiguresTemplatesRelationExample;
import top.buukle.generator.entity.constants.ConfiguresTemplatesRelationEnums;
import top.buukle.generator.entity.vo.ConfiguresTemplatesRelationQuery;
import top.buukle.generator.service.ConfiguresTemplatesRelationService;
import top.buukle.generator.service.constants.SystemReturnEnum;
import top.buukle.generator.service.exception.SystemException;
import top.buukle.generator.utils.ConvertHumpUtil;
import top.buukle.generator.utils.DateUtil;
import top.buukle.generator.utils.JsonUtil;
import top.buukle.generator.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description ConfiguresTemplatesRelationService实现类
*/
@Service("configuresTemplatesRelationService")
public class ConfiguresTemplatesRelationServiceImpl implements ConfiguresTemplatesRelationService{

    @Autowired
    private ConfiguresTemplatesRelationMapper configuresTemplatesRelationMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((ConfiguresTemplatesRelationQuery)query).getPage(),((ConfiguresTemplatesRelationQuery)query).getPageSize());
        List<ConfiguresTemplatesRelation> list = configuresTemplatesRelationMapper.selectByExample(this.assExampleForList(((ConfiguresTemplatesRelationQuery)query)));
        PageInfo<ConfiguresTemplatesRelation> pageInfo = new PageInfo<>(list);
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
        if(configuresTemplatesRelationMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, ConfiguresTemplatesRelationEnums.status.DELETED.value(),request,response)) != 1){
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
        ConfiguresTemplatesRelationExample configuresTemplatesRelationExample = new ConfiguresTemplatesRelationExample();
        ConfiguresTemplatesRelationExample.Criteria criteria = configuresTemplatesRelationExample.createCriteria();
        criteria.andIdIn(idList);
        ConfiguresTemplatesRelation configuresTemplatesRelation = new ConfiguresTemplatesRelation();

        configuresTemplatesRelation.setGmtModified(new Date());

        configuresTemplatesRelation.setStatus(ConfiguresTemplatesRelationEnums.status.DELETED.value());
        configuresTemplatesRelationMapper.updateByExampleSelective(configuresTemplatesRelation,configuresTemplatesRelationExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.top.buukle.generator .entity.ConfiguresTemplatesRelation
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public ConfiguresTemplatesRelation selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new ConfiguresTemplatesRelation();
        }
        ConfiguresTemplatesRelation configuresTemplatesRelation = configuresTemplatesRelationMapper.selectByPrimaryKey(id);
        return configuresTemplatesRelation == null ? new ConfiguresTemplatesRelation() : configuresTemplatesRelation;
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
    public CommonResponse saveOrEdit(ConfiguresTemplatesRelationQuery query, HttpServletRequest request, HttpServletResponse response) {

        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            this.save(query,request,response);
            // 更新状态为通过
            ConfiguresTemplatesRelationQuery queryForUpdate = new ConfiguresTemplatesRelationQuery();
            queryForUpdate.setId(query.getId());
            queryForUpdate.setStatus(ConfiguresTemplatesRelationEnums.status.PUBLISHED.value());
            this.update(queryForUpdate,request,response);
        }
        // 更新
        else{
            this.update(query,request,response);
        }
        return new CommonResponse.Builder().buildSuccess();
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("ConfiguresTemplatesRelation"));
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

        configuresTemplatesRelationMapper.insert(this.assQueryForInsert((ConfiguresTemplatesRelationQuery)query,request,response));
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
        ConfiguresTemplatesRelationQuery configuresTemplatesRelationQuery = ((ConfiguresTemplatesRelationQuery)query);

        ConfiguresTemplatesRelationExample example = new ConfiguresTemplatesRelationExample();
        ConfiguresTemplatesRelationExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(configuresTemplatesRelationQuery.getId());
        configuresTemplatesRelationQuery.setGmtModified(new Date());
        configuresTemplatesRelationMapper.updateByExampleSelective(configuresTemplatesRelationQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(ConfiguresTemplatesRelationQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private ConfiguresTemplatesRelation assQueryForInsert(ConfiguresTemplatesRelationQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(ConfiguresTemplatesRelationEnums.status.INIT.value());
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
    private ConfiguresTemplatesRelation assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        ConfiguresTemplatesRelationQuery infoQuery = new ConfiguresTemplatesRelationQuery();
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
    private ConfiguresTemplatesRelationExample assExampleForList(ConfiguresTemplatesRelationQuery query) {
        ConfiguresTemplatesRelationExample example = new ConfiguresTemplatesRelationExample();
        ConfiguresTemplatesRelationExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
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