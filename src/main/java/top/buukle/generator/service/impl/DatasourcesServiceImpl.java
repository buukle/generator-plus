package top.buukle.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.buukle.generator.commons.call.CommonRequest;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.commons.mvc.dto.CommonDTO;
import top.buukle.generator.commons.session.SessionUtils;
import top.buukle.generator.commons.session.UserDO;
import top.buukle.generator.commons.status.StatusConstants;
import top.buukle.generator.dao.DatasourcesMapper;
import top.buukle.generator.entity.Datasources;
import top.buukle.generator.entity.dto.datasources.DatasourcesQueryDTO;
import top.buukle.generator.entity.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO;
import top.buukle.generator.service.DatasourcesService;
import top.buukle.generator.service.constants.SystemReturnEnum;
import top.buukle.generator.service.exception.SystemException;
import top.buukle.generator.utils.DateUtil;
import top.buukle.generator.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description DatasourcesService实现类
*/
@Service("datasourcesService")
public class DatasourcesServiceImpl extends ServiceImpl<DatasourcesMapper<Datasources>, Datasources> implements DatasourcesService<Datasources,DatasourcesQueryVO,DatasourcesQueryDTO,DatasourcesUpdateDTO>{


    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author zhanglei451
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<Boolean> save(CommonRequest<CommonDTO> commonRequest) {
        DatasourcesUpdateDTO datasourcesUpdateDTO = (DatasourcesUpdateDTO) commonRequest.getBody();
        // 转换DTO
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesUpdateDTO,datasources);
        // 初始字段
        this.saveInit(datasources);
        // 落库
        boolean success = super.save(datasources);
        // 返回
        return new CommonResponse.Builder().buildBoolean(success);
    }

    /**
     * @description 删
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author zhanglei451
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<Boolean> delete(CommonRequest<CommonDTO> commonRequest) {
        // 校验参数
        DatasourcesUpdateDTO datasourcesUpdateDTO = (DatasourcesUpdateDTO) commonRequest.getBody();
        if(datasourcesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesUpdateDTO,datasources);
        this.updateInit(datasources);
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
     * @Author zhanglei451
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<Boolean> updateById(CommonRequest<CommonDTO> commonRequest) {
        DatasourcesUpdateDTO datasourcesUpdateDTO = (DatasourcesUpdateDTO) commonRequest.getBody();
        // 转换DTO
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesUpdateDTO,datasources);
        this.updateInit(datasources);
        // 落库
        boolean success = super.updateById(datasources);
        // 返回
        return new CommonResponse.Builder().buildBoolean(success);
    }

    /**
     * @description 查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<? extends top.buukle.generator.commons.mvc.vo.CommonVO>
     * @Author zhanglei451
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<DatasourcesQueryVO> getById(CommonRequest<CommonDTO> commonRequest) {
        DatasourcesQueryDTO datasourcesQueryDTO = (DatasourcesQueryDTO) commonRequest.getBody();
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
     * @description 查 - 条件分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<? extends top.buukle.generator.commons.mvc.vo.CommonVO>
     * @Author zhanglei451
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<DatasourcesQueryVO> getPage(CommonRequest<CommonDTO> commonRequest) {
        // 转换DTO
        DatasourcesQueryDTO datasourcesQueryDTO = (DatasourcesQueryDTO) commonRequest.getBody();
        Datasources datasources = new Datasources();
        BeanUtils.copyProperties(datasourcesQueryDTO,datasources);
        // 组织条件
        QueryWrapper<Datasources> queryWrapper = this.assPageParam(datasourcesQueryDTO);
        // 查询
        PageHelper.startPage(datasourcesQueryDTO.getPageNo(),datasourcesQueryDTO.getPageSize());
        List<Datasources> list = super.list(queryWrapper);
        PageInfo<Datasources> pageInfo = new PageInfo<>(list);
        // 处理分页
        List<DatasourcesQueryVO> queryVOList = new ArrayList<>();
        for (Datasources datasourcesDB : list) {
            DatasourcesQueryVO datasourcesQueryVO = new DatasourcesQueryVO();
            BeanUtils.copyProperties(datasourcesDB, datasourcesQueryVO);
            queryVOList.add(datasourcesQueryVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    private QueryWrapper<Datasources> assPageParam( DatasourcesQueryDTO datasourcesQueryDTO) {
        QueryWrapper<Datasources> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(datasourcesQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(datasourcesQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(datasourcesQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(datasourcesQueryDTO.getStartTime()));
        }
        queryWrapper.orderByDesc("gmt_modified");
        // 可按需扩展 ...
        return queryWrapper;
    }

    @Override
    public void saveInit(Datasources datasources) {
        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        datasources.setGmtCreated(date);
        datasources.setCreator(operator.getUsername());
        datasources.setCreatorCode(operator.getUserId());

        datasources.setGmtModified(date);
        datasources.setModifier(operator.getUsername());
        datasources.setModifierCode(operator.getUserId());

    }

    @Override
    public void updateInit(Datasources datasources) {

        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        datasources.setGmtModified(date);
        datasources.setModifier(operator.getUsername());
        datasources.setModifierCode(operator.getUserId());

    }

}