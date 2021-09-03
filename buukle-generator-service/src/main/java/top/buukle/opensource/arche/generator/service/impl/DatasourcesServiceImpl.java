package top.buukle.opensource.arche.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.buukle.commons.call.CommonRequest;
import top.buukle.commons.call.CommonResponse;
import top.buukle.commons.call.PageResponse;
import top.buukle.commons.session.SessionUtils;
import top.buukle.commons.session.UserDO;
import top.buukle.commons.status.StatusConstants;
import top.buukle.opensource.arche.generator.dao.DatasourcesMapper;
import top.buukle.opensource.arche.generator.dos.enums.DatasourcesEnums;
import top.buukle.opensource.arche.generator.entity.model.Datasources;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesQueryVO;
import top.buukle.opensource.arche.generator.service.util.DataBaseUtil;
import top.buukle.opensource.arche.generator.service.util.enums.DatabaseType;
import top.buukle.opensource.arche.generator.service.DatasourcesService;
import top.buukle.opensource.arche.generator.service.constants.SystemReturnEnum;
import top.buukle.opensource.arche.generator.service.exception.SystemException;
import top.buukle.utils.DateUtil;
import top.buukle.utils.StringUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description DatasourcesService实现类
*/
@Service("datasourcesService")
public class DatasourcesServiceImpl extends ServiceImpl<DatasourcesMapper, Datasources> implements DatasourcesService<Datasources, DatasourcesQueryVO, DatasourcesQueryDTO, DatasourcesUpdateDTO>{


    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<Boolean> add(CommonRequest<DatasourcesUpdateDTO> commonRequest) {
        DatasourcesUpdateDTO datasourcesUpdateDTO = commonRequest.getBody();
        // 转换DTO
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesUpdateDTO,datasources);
        // 初始字段
        this.savePre(datasources);
        datasources.setStatus(DatasourcesEnums.status.PUBLISHED.value());
        // 落库
        boolean success = super.save(datasources);
        // 返回
        return new CommonResponse.Builder().buildBoolean(success);
    }

    /**
     * @description 增or改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<Boolean> addOrEdit(CommonRequest<DatasourcesUpdateDTO> commonRequest) {
        DatasourcesUpdateDTO datasourcesUpdateDTO = commonRequest.getBody();
        // 增
        if(datasourcesUpdateDTO.getId() != null){
            return this.add(commonRequest);
        }
        // 改
        else{
            return this.updateById(commonRequest);
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
    public CommonResponse<Boolean> deleteById(CommonRequest<DatasourcesUpdateDTO> commonRequest) {
        DatasourcesUpdateDTO datasourcesUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(datasourcesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesUpdateDTO,datasources);
        this.updatePre(datasources);
        datasources.setStatus(StatusConstants.DELETED);
        // 落库
        boolean success = super.updateById(datasources);
        // 返回
        return new CommonResponse.Builder().buildBoolean(success);
    }

    /**
     * @description 改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<Boolean> updateById(CommonRequest<DatasourcesUpdateDTO> commonRequest) {
        DatasourcesUpdateDTO datasourcesUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(datasourcesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesUpdateDTO,datasources);
        // 更新字段
        this.updatePre(datasources);
        // 落库
        boolean success = super.updateById(datasources);
        // 返回
        return new CommonResponse.Builder().buildBoolean(success);
    }

    /**
     * @description  查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<DatasourcesQueryVO> getById(CommonRequest<DatasourcesQueryDTO> commonRequest) {
        DatasourcesQueryDTO datasourcesQueryDTO = commonRequest.getBody();
        // 验证参数
        if(datasourcesQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 执行查询
        Datasources one = super.getById(datasourcesQueryDTO.getId());
        // 转换响应
        DatasourcesQueryVO datasourcesQueryVO = new DatasourcesQueryVO();
        BeanUtils.copyProperties(one,datasourcesQueryVO);
        CommonResponse<DatasourcesQueryVO> datasourcesQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(datasourcesQueryVO);
        return datasourcesQueryVOCommonResponse;
    }

    /**
     * @description 查 - 分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<DatasourcesQueryVO> getPage(CommonRequest<DatasourcesQueryDTO> commonRequest) {
        // 转换DTO
        DatasourcesQueryDTO datasourcesQueryDTO = commonRequest.getBody();
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesQueryDTO,datasources);
        // 条件
        QueryWrapper<Datasources> queryWrapper = this.assPageParam(datasourcesQueryDTO);
        // 查询
        PageHelper.startPage(datasourcesQueryDTO.getPageNo(),datasourcesQueryDTO.getPageSize());
        List<Datasources> list = super.list(queryWrapper);
        PageInfo<Datasources> pageInfo = new PageInfo<>(list);
        // 分页
        List<DatasourcesQueryVO> queryVOList = new ArrayList<>();
        for (Datasources datasourcesDB : list) {
            DatasourcesQueryVO datasourcesQueryVO = new DatasourcesQueryVO();
            BeanUtils.copyProperties(datasourcesDB, datasourcesQueryVO);
            queryVOList.add(datasourcesQueryVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description 组装分页条件
     * @param datasourcesQueryDTO
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<top.buukle.generator.entity.model.Datasources>
     * @Author 17600
     * @Date 2021/9/2
     */
    private QueryWrapper<Datasources> assPageParam( DatasourcesQueryDTO datasourcesQueryDTO) {
        QueryWrapper<Datasources> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(datasourcesQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(datasourcesQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(datasourcesQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(datasourcesQueryDTO.getStartTime()));
        }
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        // 可按需扩展 ...
        return queryWrapper;
    }

    /**
     * @description 增 - 初始化
     * @param datasources
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(Datasources datasources) {
        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        datasources.setGmtCreated(date);
        datasources.setCreator(operator.getUsername());
        datasources.setCreatorCode(operator.getUserId());
        datasources.setCreatorDeptId(Integer.parseInt(StringUtil.isEmpty(operator.getDeptId())?"-1":operator.getDeptId()));
        datasources.setGmtModified(date);

        datasources.setModifier(operator.getUsername());
        datasources.setModifierCode(operator.getUserId());
        datasources.setStatus(DatasourcesEnums.status.INIT.value());

    }

    /**
     * @description 改 - 初始化
     * @param datasources
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(Datasources datasources) {

        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        datasources.setGmtModified(date);
        datasources.setModifier(operator.getUsername());
        datasources.setModifierCode(operator.getUserId());

    }

    /*------------------------------------------------------↑↑↑↑通用可定制代码↑↑↑↑-------------------------------------------------------------*/
    /**
     * @description 测试数据源链接
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/3
     */
    @Override
    public CommonResponse<Boolean> testLink(CommonRequest<DatasourcesUpdateDTO> commonRequest) throws SQLException {
        DatasourcesUpdateDTO body = commonRequest.getBody();
        Connection connection = DataBaseUtil.getConnection(DatabaseType.MySQL, body.getUsername(), body.getPassword(), body.getUrl());
        connection.close();
        return new CommonResponse.Builder().buildSuccess();
    }
}