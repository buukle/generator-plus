package top.buukle.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
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
import top.buukle.generator.dao.DatasourcesMapper;
import top.buukle.generator.entity.Datasources;
import top.buukle.generator.entity.DatasourcesExample;
import top.buukle.generator.entity.constants.DatasourcesEnums;
import top.buukle.generator.entity.vo.DatasourcesQuery;
import top.buukle.generator.entity.vo.TableVo;
import top.buukle.generator.invoker.DataBaseUtil;
import top.buukle.generator.invoker.enums.DatabaseType;
import top.buukle.generator.service.DatasourcesService;
import top.buukle.generator.service.constants.SystemReturnEnum;
import top.buukle.generator.service.exception.SystemException;
import top.buukle.generator.utils.ConvertHumpUtil;
import top.buukle.generator.utils.DateUtil;
import top.buukle.generator.utils.JsonUtil;
import top.buukle.generator.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description DatasourcesService实现类
*/
@Service("datasourcesService")
public class DatasourcesServiceImpl implements DatasourcesService{

    @Autowired
    private DatasourcesMapper datasourcesMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse<Datasources>  getPage(BaseQuery query) {
        PageHelper.startPage(((DatasourcesQuery)query).getPage(),((DatasourcesQuery)query).getPageSize());
        List<Datasources> list = datasourcesMapper.selectByExample(this.assExampleForList(((DatasourcesQuery)query)));
        PageInfo<Datasources> pageInfo = new PageInfo<>(list);
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
        if(datasourcesMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, DatasourcesEnums.status.DELETED.value(),request,response)) != 1){
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
        DatasourcesExample datasourcesExample = new DatasourcesExample();
        DatasourcesExample.Criteria criteria = datasourcesExample.createCriteria();
        criteria.andIdIn(idList);
        Datasources datasources = new Datasources();

        datasources.setGmtModified(new Date());

        datasources.setStatus(DatasourcesEnums.status.DELETED.value());
        datasourcesMapper.updateByExampleSelective(datasources,datasourcesExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.top.buukle.generator .entity.Datasources
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public Datasources selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new Datasources();
        }
        Datasources datasources = datasourcesMapper.selectByPrimaryKey(id);
        return datasources == null ? new Datasources() : datasources;
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
    public CommonResponse saveOrEdit(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response) {


        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            this.save(query,request,response);
            // 更新状态为通过
            DatasourcesQuery queryForUpdate = new DatasourcesQuery();
            queryForUpdate.setId(query.getId());
            queryForUpdate.setStatus(DatasourcesEnums.status.PUBLISHED.value());
            this.update(queryForUpdate,request,response);
        }
        // 更新
        else{
            this.update(query,request,response);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 测试连接
     * @param query
     * @param request
     * @param response
     * @return top.buukle.generator.commons.call.CommonResponse
     * @Author elvin
     * @Date 2021/5/12
     */
    @Override
    public CommonResponse testLink(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection = DataBaseUtil.getConnection(DatabaseType.MySQL, query.getUsername(), query.getPassword(), query.getUrl());
        connection.close();
        return new CommonResponse.Builder<>().buildSuccess();
    }

    @Override
    public PageResponse<DatasourcesQuery> getDatasources(DatasourcesQuery query) {
        List<Datasources> list = datasourcesMapper.selectByExample(this.assExampleForList(query));
        List<DatasourcesQuery>  queryList = new ArrayList<>();
        for (Datasources datasources : list){
            DatasourcesQuery datasourcesQuery = new DatasourcesQuery();
            BeanUtils.copyProperties(datasources,datasourcesQuery);
            datasourcesQuery.setTitle(datasources.getName());
            queryList.add(datasourcesQuery);
        }
        return new PageResponse.Builder().build(queryList,0,0,0);
    }

    @Override
    public PageResponse<String> getTables(DatasourcesQuery query) throws SQLException {
        Datasources datasources = datasourcesMapper.selectByPrimaryKey(query.getId());
        Connection connection = DataBaseUtil.getConnection(DatabaseType.MySQL, datasources.getUsername(), datasources.getPassword(), datasources.getUrl());
        List<String> tables = DataBaseUtil.getTables(connection);
        connection.close();
        return new PageResponse.Builder().build(tables,0,0,0);
    }

    @Override
    public PageResponse<TableVo> getTablesList(DatasourcesQuery query) throws SQLException {
        Datasources datasources = datasourcesMapper.selectByPrimaryKey(query.getId());
        Connection connection = DataBaseUtil.getConnection(DatabaseType.MySQL, datasources.getUsername(), datasources.getPassword(), datasources.getUrl());
        List<String> tables = DataBaseUtil.getTables(connection);
        connection.close();
        ArrayList<TableVo> tableVos = new ArrayList<>();
        for (String table : tables) {
            tableVos.add(new TableVo(table,false));
        }
        return new PageResponse.Builder().build(tableVos,0,0,0);
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Datasources"));
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

        datasourcesMapper.insert(this.assQueryForInsert((DatasourcesQuery)query,request,response));
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
        DatasourcesQuery datasourcesQuery = ((DatasourcesQuery)query);

        DatasourcesExample example = new DatasourcesExample();
        DatasourcesExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(datasourcesQuery.getId());
        datasourcesQuery.setGmtModified(new Date());
        datasourcesMapper.updateByExampleSelective(datasourcesQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(DatasourcesQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Datasources assQueryForInsert(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(DatasourcesEnums.status.INIT.value());
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
    private Datasources assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        DatasourcesQuery infoQuery = new DatasourcesQuery();
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
    private DatasourcesExample assExampleForList(DatasourcesQuery query) {
        DatasourcesExample example = new DatasourcesExample();
        DatasourcesExample.Criteria criteria = example.createCriteria();
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