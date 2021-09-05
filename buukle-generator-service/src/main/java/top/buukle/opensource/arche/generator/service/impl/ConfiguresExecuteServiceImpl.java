package top.buukle.opensource.arche.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.buukle.business.base.commons.call.CommonRequest;
import top.buukle.business.base.commons.call.CommonResponse;
import top.buukle.business.base.commons.call.PageResponse;
import top.buukle.business.base.commons.session.SessionUtils;
import top.buukle.business.base.commons.session.UserDO;
import top.buukle.business.base.commons.status.StatusConstants;
import top.buukle.opensource.arche.generator.dao.ConfiguresExecuteMapper;
import top.buukle.opensource.arche.generator.dos.dto.configuresExecute.ConfiguresExecuteQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.configuresExecute.ConfiguresExecuteUpdateDTO;
import top.buukle.opensource.arche.generator.dos.enums.ConfiguresExecuteEnums;
import top.buukle.opensource.arche.generator.dos.vo.configuresExecute.ConfiguresExecuteVO;
import top.buukle.opensource.arche.generator.entity.ConfiguresExecute;
import top.buukle.opensource.arche.generator.service.ConfiguresExecuteService;
import top.buukle.opensource.arche.generator.service.constants.SystemReturnEnum;
import top.buukle.opensource.arche.generator.service.exception.SystemException;
import top.buukle.business.base.utils.DateUtil;
import top.buukle.business.base.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description ConfiguresExecuteService实现类
*/
@Service("configuresExecuteService")
public class ConfiguresExecuteServiceImpl extends ServiceImpl<ConfiguresExecuteMapper, ConfiguresExecute> implements ConfiguresExecuteService<ConfiguresExecute, ConfiguresExecuteVO, ConfiguresExecuteQueryDTO, ConfiguresExecuteUpdateDTO> {


    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresExecuteVO> add(CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) {
        ConfiguresExecuteUpdateDTO configuresExecuteUpdateDTO = commonRequest.getBody();
        // 转换DTO
        ConfiguresExecute configuresExecute = new ConfiguresExecute();
        BeanUtils.copyProperties(configuresExecuteUpdateDTO,configuresExecute);
        // 初始字段
        this.savePre(configuresExecute);
        configuresExecute.setStatus(ConfiguresExecuteEnums.status.PUBLISHED.value());
        // 落库
        super.save(configuresExecute);
        // 返回
        ConfiguresExecuteVO configuresExecuteVO = new ConfiguresExecuteVO();
        BeanUtils.copyProperties(configuresExecute, configuresExecuteVO);
        return new CommonResponse.Builder().buildSuccess(configuresExecuteVO);
    }

    /**
     * @description 增or改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresExecuteVO> addOrEdit(CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) {
        ConfiguresExecuteUpdateDTO configuresExecuteUpdateDTO = commonRequest.getBody();
        // 增
        if(configuresExecuteUpdateDTO.getId() == null){
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
    public CommonResponse<ConfiguresExecuteVO> deleteById(CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) {
        ConfiguresExecuteUpdateDTO configuresExecuteUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(configuresExecuteUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        ConfiguresExecute configuresExecute = new ConfiguresExecute();
        BeanUtils.copyProperties(configuresExecuteUpdateDTO,configuresExecute);
        this.updatePre(configuresExecute);
        configuresExecute.setStatus(StatusConstants.DELETED);
        // 落库
        super.updateById(configuresExecute);
        // 返回
        ConfiguresExecuteVO configuresExecuteVO = new ConfiguresExecuteVO();
        BeanUtils.copyProperties(configuresExecute, configuresExecuteVO);
        return new CommonResponse.Builder().buildSuccess(configuresExecuteVO);
    }

    /**
     * @description 改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresExecuteVO> updateById(CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) {
        ConfiguresExecuteUpdateDTO configuresExecuteUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(configuresExecuteUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        ConfiguresExecute configuresExecute = new ConfiguresExecute();
        BeanUtils.copyProperties(configuresExecuteUpdateDTO,configuresExecute);
        // 更新字段
        this.updatePre(configuresExecute);
        // 落库
        super.updateById(configuresExecute);
        // 返回
        ConfiguresExecuteVO configuresExecuteVO = new ConfiguresExecuteVO();
        BeanUtils.copyProperties(configuresExecute, configuresExecuteVO);
        return new CommonResponse.Builder().buildSuccess(configuresExecuteVO);
    }

    /**
     * @description  查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.ConfiguresExecute.ConfiguresExecuteQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<ConfiguresExecuteVO> getById(CommonRequest<ConfiguresExecuteQueryDTO> commonRequest) {
        ConfiguresExecuteQueryDTO ConfiguresExecuteQueryDTO = commonRequest.getBody();
        // 验证参数
        if(ConfiguresExecuteQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 执行查询
        ConfiguresExecute one = super.getById(ConfiguresExecuteQueryDTO.getId());
        // 转换响应
        ConfiguresExecuteVO ConfiguresExecuteVO = new ConfiguresExecuteVO();
        BeanUtils.copyProperties(one, ConfiguresExecuteVO);
        CommonResponse<ConfiguresExecuteVO> ConfiguresExecuteQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(ConfiguresExecuteVO);
        return ConfiguresExecuteQueryVOCommonResponse;
    }

    /**
     * @description 查 - 分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.ConfiguresExecute.ConfiguresExecuteQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<ConfiguresExecuteVO> getPage(CommonRequest<ConfiguresExecuteQueryDTO> commonRequest) {
        // 转换DTO
        ConfiguresExecuteQueryDTO ConfiguresExecuteQueryDTO = commonRequest.getBody();
        ConfiguresExecute ConfiguresExecute = new ConfiguresExecute();
        BeanUtils.copyProperties(ConfiguresExecuteQueryDTO,ConfiguresExecute);
        // 条件
        QueryWrapper<ConfiguresExecute> queryWrapper = this.assPageParam(ConfiguresExecuteQueryDTO);
        // 查询
        PageHelper.startPage(ConfiguresExecuteQueryDTO.getPageNo(),ConfiguresExecuteQueryDTO.getPageSize());
        List<ConfiguresExecute> list = super.list(queryWrapper);
        PageInfo<ConfiguresExecute> pageInfo = new PageInfo<>(list);
        // 分页
        List<ConfiguresExecuteVO> queryVOList = new ArrayList<>();
        for (ConfiguresExecute ConfiguresExecuteDB : list) {
            ConfiguresExecuteVO ConfiguresExecuteVO = new ConfiguresExecuteVO();
            BeanUtils.copyProperties(ConfiguresExecuteDB, ConfiguresExecuteVO);
            queryVOList.add(ConfiguresExecuteVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description 组装分页条件
     * @param ConfiguresExecuteQueryDTO
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<top.buukle.generator.entity.model.ConfiguresExecute>
     * @Author 17600
     * @Date 2021/9/2
     */
    private QueryWrapper<ConfiguresExecute> assPageParam( ConfiguresExecuteQueryDTO ConfiguresExecuteQueryDTO) {
        QueryWrapper<ConfiguresExecute> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(ConfiguresExecuteQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(ConfiguresExecuteQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(ConfiguresExecuteQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(ConfiguresExecuteQueryDTO.getStartTime()));
        }
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        // 可按需扩展 ...
        return queryWrapper;
    }

    /**
     * @description 增 - 初始化
     * @param ConfiguresExecute
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(ConfiguresExecute ConfiguresExecute) {
        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        ConfiguresExecute.setGmtCreated(date);
        ConfiguresExecute.setCreator(operator.getUsername());
        ConfiguresExecute.setCreatorCode(operator.getUserId());
        ConfiguresExecute.setCreatorDeptId(Integer.parseInt(StringUtil.isEmpty(operator.getDeptId())?"-1":operator.getDeptId()));
        ConfiguresExecute.setGmtModified(date);

        ConfiguresExecute.setModifier(operator.getUsername());
        ConfiguresExecute.setModifierCode(operator.getUserId());
        ConfiguresExecute.setStatus(ConfiguresExecuteEnums.status.INIT.value());

    }

    /**
     * @description 改 - 初始化
     * @param ConfiguresExecute
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(ConfiguresExecute ConfiguresExecute) {

        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        ConfiguresExecute.setGmtModified(date);
        ConfiguresExecute.setModifier(operator.getUsername());
        ConfiguresExecute.setModifierCode(operator.getUserId());

    }

    /**
     * @description 更新状态 - 行锁
     * @param originStatus
     * @param targetStatus
     * @param id
     * @return void
     * @Author 17600
     * @Date 2021/9/4
     */
    @Override
    public void updateStatus(Integer originStatus, Integer targetStatus, Integer id) {

        UpdateWrapper<ConfiguresExecute> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("status",originStatus);
        updateWrapper.eq("id",id);

        ConfiguresExecute configuresExecute = new ConfiguresExecute();
        configuresExecute.setStatus(targetStatus);

        super.update(configuresExecute,updateWrapper);
    }
}