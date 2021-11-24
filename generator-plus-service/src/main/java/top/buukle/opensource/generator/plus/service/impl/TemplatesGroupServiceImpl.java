package top.buukle.opensource.generator.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse.Builder;
import top.buukle.opensource.generator.plus.commons.call.PageResponse;
import top.buukle.opensource.generator.plus.commons.session.SessionUtils;
import top.buukle.opensource.generator.plus.commons.session.UserDTO;
import top.buukle.opensource.generator.plus.commons.status.StatusConstants;
import top.buukle.opensource.generator.plus.dao.TemplatesGroupMapper;
import top.buukle.opensource.generator.plus.dtvo.enums.TemplatesGroupEnums;
import top.buukle.opensource.generator.plus.entity.TemplatesGroup;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.vo.templatesGroup.TemplatesGroupVO;
import top.buukle.opensource.generator.plus.service.TemplatesGroupService;
import top.buukle.opensource.generator.plus.service.constants.SystemReturnEnum;
import top.buukle.opensource.generator.plus.service.exception.SystemException;
import top.buukle.opensource.generator.plus.utils.DateUtil;
import top.buukle.opensource.generator.plus.utils.JsonUtil;
import top.buukle.opensource.generator.plus.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description TemplatesGroupService实现类
*/
@Service("templatesGroupService")
public class TemplatesGroupServiceImpl extends ServiceImpl<TemplatesGroupMapper, TemplatesGroup> implements TemplatesGroupService<TemplatesGroup, TemplatesGroupVO, TemplatesGroupQueryDTO, TemplatesGroupUpdateDTO>{


    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> add(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // 转换DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        if(!CollectionUtils.isEmpty(templatesGroupUpdateDTO.getParamList())){
            templatesGroup.setParams(JsonUtil.toJSONString(templatesGroupUpdateDTO.getParamList()));
        }
        // 初始字段
        this.savePre(templatesGroup);
        templatesGroup.setStatus(TemplatesGroupEnums.status.PUBLISHED.value());
        // 落库
        super.save(templatesGroup);
        // 返回
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }

    /**
     * @description 增or改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> addOrEdit(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // 增
        if(templatesGroupUpdateDTO.getId() == null){
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
    public CommonResponse<TemplatesGroupVO> deleteById(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(templatesGroupUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        this.updatePre(templatesGroup);
        templatesGroup.setStatus(StatusConstants.DELETED);
        // 落库
        super.updateById(templatesGroup);
        // 返回
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }

    /**
     * @description 改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> updateById(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(templatesGroupUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        if(!CollectionUtils.isEmpty(templatesGroupUpdateDTO.getParamList())){
            templatesGroup.setParams(JsonUtil.toJSONString(templatesGroupUpdateDTO.getParamList()));
        }else{
            templatesGroup.setParams("");
        }
        // 更新字段
        this.updatePre(templatesGroup);
        // 落库
        super.updateById(templatesGroup);
        // 返回
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }

    /**
     * @description  查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.templatesGroup.TemplatesGroupQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> getById(CommonRequest<TemplatesGroupQueryDTO> commonRequest) {
        TemplatesGroupQueryDTO templatesGroupQueryDTO = commonRequest.getBody();
        // 验证参数
        if(templatesGroupQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 执行查询
        TemplatesGroup one = super.getById(templatesGroupQueryDTO.getId());
        // 转换响应
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(one, templatesGroupVO);
        if(StringUtil.isNotEmpty(one.getParams())){
            templatesGroupVO.setParamList(JsonUtil.parseArray(one.getParams(), TemplatesGroupVO.Param.class));
        }
        CommonResponse<TemplatesGroupVO> templatesGroupQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(templatesGroupVO);
        return templatesGroupQueryVOCommonResponse;
    }

    /**
     * @description 查 - 分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.templatesGroup.TemplatesGroupQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<TemplatesGroupVO> getPage(CommonRequest<TemplatesGroupQueryDTO> commonRequest) {
        // 转换DTO
        TemplatesGroupQueryDTO templatesGroupQueryDTO = commonRequest.getBody();
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupQueryDTO,templatesGroup);
        // 条件
        QueryWrapper<TemplatesGroup> queryWrapper = this.assPageParam(templatesGroupQueryDTO);
        // 查询
        PageHelper.startPage(templatesGroupQueryDTO.getPageNo(),templatesGroupQueryDTO.getPageSize());
        List<TemplatesGroup> list = super.list(queryWrapper);
        PageInfo<TemplatesGroup> pageInfo = new PageInfo<>(list);
        // 分页
        List<TemplatesGroupVO> queryVOList = new ArrayList<>();
        for (TemplatesGroup templatesGroupDB : list) {
            TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
            BeanUtils.copyProperties(templatesGroupDB, templatesGroupVO);
            queryVOList.add(templatesGroupVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description 组装分页条件
     * @param templatesGroupQueryDTO
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<top.buukle.generator.entity.model.TemplatesGroup>
     * @Author 17600
     * @Date 2021/9/2
     */
    private QueryWrapper<TemplatesGroup> assPageParam( TemplatesGroupQueryDTO templatesGroupQueryDTO) {
        QueryWrapper<TemplatesGroup> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(templatesGroupQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(templatesGroupQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(templatesGroupQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(templatesGroupQueryDTO.getStartTime()));
        }
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        // 可按需扩展 ...
        return queryWrapper;
    }

    /**
     * @description 增 - 初始化
     * @param templatesGroup
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(TemplatesGroup templatesGroup) {
        Date date = new Date();

        UserDTO operator = SessionUtils.getOperator();

        templatesGroup.setGmtCreated(date);
        templatesGroup.setCreator(operator.getUsername());
        templatesGroup.setCreatorCode(operator.getUserId());
        templatesGroup.setCreatorTenantId(Integer.parseInt(StringUtil.isEmpty(operator.getTenantId())?"-1":operator.getTenantId()));
        templatesGroup.setGmtModified(date);

        templatesGroup.setModifier(operator.getUsername());
        templatesGroup.setModifierCode(operator.getUserId());
        templatesGroup.setStatus(TemplatesGroupEnums.status.INIT.value());

    }

    /**
     * @description 改 - 初始化
     * @param templatesGroup
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(TemplatesGroup templatesGroup) {

        Date date = new Date();

        UserDTO operator = SessionUtils.getOperator();

        templatesGroup.setGmtModified(date);
        templatesGroup.setModifier(operator.getUsername());
        templatesGroup.setModifierCode(operator.getUserId());

    }
    /*------------------------------------------------------↑↑↑↑通用可定制代码↑↑↑↑-------------------------------------------------------------*/

    @Override
    public CommonResponse<List<TemplatesGroupVO>> getTemplatesGroupList(CommonRequest<TemplatesGroupQueryDTO> commonRequest) {

        QueryWrapper<TemplatesGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        List<TemplatesGroup> list = super.list(queryWrapper);
        List<TemplatesGroupVO> queryVOList = new ArrayList<>();
        for (TemplatesGroup templatesGroupDB : list) {
            TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
            BeanUtils.copyProperties(templatesGroupDB, templatesGroupVO);
            queryVOList.add(templatesGroupVO);
        }
        CommonResponse<List<TemplatesGroupVO>> listCommonResponse = new Builder().buildSuccess(queryVOList);
        return listCommonResponse;
    }
}
