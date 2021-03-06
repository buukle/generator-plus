package top.buukle.opensource.generator.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.buukle.login.cube.session.SessionUtils;
import top.buukle.login.cube.session.UserDTO;
import top.buukle.login.cube.session.tenant.TenantHelper;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse.Builder;
import top.buukle.opensource.generator.plus.commons.call.PageResponse;
import top.buukle.opensource.generator.plus.commons.status.StatusConstants;
import top.buukle.opensource.generator.plus.dao.TemplatesGroupMapper;
import top.buukle.opensource.generator.plus.dtvo.enums.TemplatesGroupEnums;
import top.buukle.opensource.generator.plus.entity.TemplatesGroup;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.vo.templatesGroup.TemplatesGroupVO;
import top.buukle.opensource.generator.plus.service.TemplatesGroupService;
import top.buukle.opensource.generator.plus.service.TemplatesService;
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
* @description TemplatesGroupService?????????
*/
@Service("templatesGroupService")
public class TemplatesGroupServiceImpl extends ServiceImpl<TemplatesGroupMapper, TemplatesGroup> implements TemplatesGroupService<TemplatesGroup, TemplatesGroupVO, TemplatesGroupQueryDTO, TemplatesGroupUpdateDTO>{


    @Autowired
    TemplatesService templatesService;

    /**
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> add(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // ??????DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        if(!CollectionUtils.isEmpty(templatesGroupUpdateDTO.getParamList())){
            templatesGroup.setParams(JsonUtil.toJSONString(templatesGroupUpdateDTO.getParamList()));
        }
        // ????????????
        this.savePre(templatesGroup);
        templatesGroup.setStatus(TemplatesGroupEnums.status.PUBLISHED.value());
        // ??????
        super.save(templatesGroup);
        // ??????
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }

    /**
     * @description ???or???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> addOrEdit(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // ???
        if(templatesGroupUpdateDTO.getId() == null){
            return this.add(commonRequest);
        }
        // ???
        else{
            return this.updateById(commonRequest);
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
    public CommonResponse<TemplatesGroupVO> deleteById(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // ????????????
        if(templatesGroupUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ??????DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        this.updatePre(templatesGroup);
        templatesGroup.setStatus(StatusConstants.DELETED);
        // ??????
        super.updateById(templatesGroup);
        templatesService.deleteTemplatesByGroupId(templatesGroup.getId());
        // ??????
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }

    /**
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> updateById(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // ????????????
        if(templatesGroupUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ??????DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        if(!CollectionUtils.isEmpty(templatesGroupUpdateDTO.getParamList())){
            templatesGroup.setParams(JsonUtil.toJSONString(templatesGroupUpdateDTO.getParamList()));
        }else{
            templatesGroup.setParams("");
        }
        // ????????????
        this.updatePre(templatesGroup);
        // ??????
        super.updateById(templatesGroup);
        // ??????
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }

    /**
     * @description  ??? - ??????
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.templatesGroup.TemplatesGroupQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesGroupVO> getById(CommonRequest<TemplatesGroupQueryDTO> commonRequest) {
        TemplatesGroupQueryDTO templatesGroupQueryDTO = commonRequest.getBody();
        // ????????????
        if(templatesGroupQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ????????????
        TenantHelper.startTenant("templates_group");
        TemplatesGroup one = super.getById(templatesGroupQueryDTO.getId());
        // ????????????
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(one, templatesGroupVO);
        if(StringUtil.isNotEmpty(one.getParams())){
            templatesGroupVO.setParamList(JsonUtil.parseArray(one.getParams(), TemplatesGroupVO.Param.class));
        }
        CommonResponse<TemplatesGroupVO> templatesGroupQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(templatesGroupVO);
        return templatesGroupQueryVOCommonResponse;
    }

    /**
     * @description ??? - ??????
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.templatesGroup.TemplatesGroupQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<TemplatesGroupVO> getPage(CommonRequest<TemplatesGroupQueryDTO> commonRequest) {
        // ??????DTO
        TemplatesGroupQueryDTO templatesGroupQueryDTO = commonRequest.getBody();
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupQueryDTO,templatesGroup);
        // ??????
        QueryWrapper<TemplatesGroup> queryWrapper = this.assPageParam(templatesGroupQueryDTO);
        // ??????
        PageHelper.startPage(templatesGroupQueryDTO.getPageNo(),templatesGroupQueryDTO.getPageSize());
        TenantHelper.startTenant("templates_group");
        List<TemplatesGroup> list = super.list(queryWrapper);
        PageInfo<TemplatesGroup> pageInfo = new PageInfo<>(list);
        // ??????
        List<TemplatesGroupVO> queryVOList = new ArrayList<>();
        for (TemplatesGroup templatesGroupDB : list) {
            TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
            BeanUtils.copyProperties(templatesGroupDB, templatesGroupVO);
            queryVOList.add(templatesGroupVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description ??????????????????
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
        // ??????????????? ...
        return queryWrapper;
    }

    /**
     * @description ??? - ?????????
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
        templatesGroup.setTenantId(Integer.parseInt(StringUtil.isEmpty(operator.getTenantId())?"-1":operator.getTenantId()));
        templatesGroup.setGmtModified(date);

        templatesGroup.setModifier(operator.getUsername());
        templatesGroup.setModifierCode(operator.getUserId());
        templatesGroup.setStatus(TemplatesGroupEnums.status.INIT.value());

    }

    /**
     * @description ??? - ?????????
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
    /*------------------------------------------------------?????????????????????????????????????????????-------------------------------------------------------------*/

    @Override
    public CommonResponse<List<TemplatesGroupVO>> getTemplatesGroupList(CommonRequest<TemplatesGroupQueryDTO> commonRequest) {

        QueryWrapper<TemplatesGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        TenantHelper.startTenant("templates_group");
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

    /**
     * @description ?????????????????????
     * @param commonRequest
     * @return top.buukle.opensource.generator.plus.commons.call.CommonResponse<top.buukle.opensource.generator.plus.dtvo.vo.templatesGroup.TemplatesGroupVO>
     * @Author zhanglei001
     * @Date 2021/11/29
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = {Exception.class})
    public CommonResponse<TemplatesGroupVO> copyWithTemplates(CommonRequest<TemplatesGroupUpdateDTO> commonRequest) {
        TemplatesGroupUpdateDTO templatesGroupUpdateDTO = commonRequest.getBody();
        // ??????DTO
        TemplatesGroup templatesGroup = new TemplatesGroup();
        BeanUtils.copyProperties(templatesGroupUpdateDTO,templatesGroup);
        if(!CollectionUtils.isEmpty(templatesGroupUpdateDTO.getParamList())){
            templatesGroup.setParams(JsonUtil.toJSONString(templatesGroupUpdateDTO.getParamList()));
        }
        // ????????????
        this.savePre(templatesGroup);
        templatesGroup.setId(null);
        templatesGroup.setStatus(TemplatesGroupEnums.status.PUBLISHED.value());
        // ??????
        super.save(templatesGroup);
        // ????????????
        templatesService.copyByGroupId(templatesGroupUpdateDTO.getId(),templatesGroup.getId(),templatesGroupUpdateDTO);
        // ??????
        TemplatesGroupVO templatesGroupVO = new TemplatesGroupVO();
        BeanUtils.copyProperties(templatesGroup, templatesGroupVO);
        return new CommonResponse.Builder().buildSuccess(templatesGroupVO);
    }
}
