package top.buukle.generator.service.impl;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.commons.call.vo.FuzzyVo;
import top.buukle.generator.commons.mvc.BaseQuery;
import top.buukle.generator.commons.status.StatusConstants;
import top.buukle.generator.dao.CommonMapper;
import top.buukle.generator.dao.ConfiguresExecuteMapper;
import top.buukle.generator.entity.ConfiguresExecute;
import top.buukle.generator.entity.ConfiguresExecuteExample;
import top.buukle.generator.entity.constants.ConfiguresExecuteEnums;
import top.buukle.generator.entity.vo.ConfiguresExecuteQuery;
import top.buukle.generator.service.ConfiguresExecuteService;
import top.buukle.generator.service.constants.SystemReturnEnum;
import top.buukle.generator.service.exception.SystemException;
import top.buukle.generator.utils.ConvertHumpUtil;
import top.buukle.generator.utils.DateUtil;
import top.buukle.generator.utils.JsonUtil;
import top.buukle.generator.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description ConfiguresExecuteService实现类
*/
@Service("configuresExecuteService")
public class ConfiguresExecuteServiceImpl implements ConfiguresExecuteService{

    @Autowired
    private ConfiguresExecuteMapper configuresExecuteMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((ConfiguresExecuteQuery)query).getPage(),((ConfiguresExecuteQuery)query).getPageSize());
        List<ConfiguresExecute> list = configuresExecuteMapper.selectByExample(this.assExampleForList(((ConfiguresExecuteQuery)query)));
        PageInfo<ConfiguresExecute> pageInfo = new PageInfo<>(list);
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
        if(configuresExecuteMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, ConfiguresExecuteEnums.status.DELETED.value(),request,response)) != 1){
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
        ConfiguresExecuteExample configuresExecuteExample = new ConfiguresExecuteExample();
        ConfiguresExecuteExample.Criteria criteria = configuresExecuteExample.createCriteria();
        criteria.andIdIn(idList);
        ConfiguresExecute configuresExecute = new ConfiguresExecute();

        configuresExecute.setGmtModified(new Date());

        configuresExecute.setStatus(ConfiguresExecuteEnums.status.DELETED.value());
        configuresExecuteMapper.updateByExampleSelective(configuresExecute,configuresExecuteExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.top.buukle.generator .entity.ConfiguresExecute
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public ConfiguresExecute selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new ConfiguresExecute();
        }
        ConfiguresExecute configuresExecute = configuresExecuteMapper.selectByPrimaryKey(id);
        return configuresExecute == null ? new ConfiguresExecute() : configuresExecute;
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
    public CommonResponse saveOrEdit(ConfiguresExecuteQuery query, HttpServletRequest request, HttpServletResponse response) {


        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            this.save(query,request,response);
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("ConfiguresExecute"));
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

        configuresExecuteMapper.insert(this.assQueryForInsert((ConfiguresExecuteQuery)query,request,response));
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
        ConfiguresExecuteQuery configuresExecuteQuery = ((ConfiguresExecuteQuery)query);

        ConfiguresExecuteExample example = new ConfiguresExecuteExample();
        ConfiguresExecuteExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(configuresExecuteQuery.getId());
        configuresExecuteQuery.setGmtModified(new Date());
        configuresExecuteMapper.updateByExampleSelective(configuresExecuteQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    public CommonResponse updateStatus(Integer originStatus,Integer targetStatus,Integer id) {
        ConfiguresExecuteQuery configuresExecuteQuerytemp = new ConfiguresExecuteQuery();
        configuresExecuteQuerytemp.setStatus(targetStatus);
        ConfiguresExecuteExample example = new ConfiguresExecuteExample();
        ConfiguresExecuteExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andStatusEqualTo(originStatus);
        configuresExecuteMapper.updateByExampleSelective(configuresExecuteQuerytemp,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(ConfiguresExecuteQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private ConfiguresExecute assQueryForInsert(ConfiguresExecuteQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(ConfiguresExecuteEnums.status.INIT.value());
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
    private ConfiguresExecute assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        ConfiguresExecuteQuery infoQuery = new ConfiguresExecuteQuery();
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
    private ConfiguresExecuteExample assExampleForList(ConfiguresExecuteQuery query) {
        ConfiguresExecuteExample example = new ConfiguresExecuteExample();
        ConfiguresExecuteExample.Criteria criteria = example.createCriteria();
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
        example.setOrderByClause("gmt_created desc");
        return example;
    }
}