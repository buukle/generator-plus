package top.buukle.opensource.generator.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.login.cube.session.SessionUtils;
import top.buukle.login.cube.session.UserDTO;
import top.buukle.login.cube.session.tenant.TenantHelper;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.call.PageResponse;
import top.buukle.opensource.generator.plus.commons.status.StatusConstants;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.enums.TemplatesGroupEnums.status;
import top.buukle.opensource.generator.plus.entity.TemplatesGroup;
import top.buukle.opensource.generator.plus.service.TemplatesGroupService;
import top.buukle.opensource.generator.plus.utils.DateUtil;
import top.buukle.opensource.generator.plus.utils.JsonUtil;
import top.buukle.opensource.generator.plus.utils.StringUtil;
import top.buukle.opensource.generator.plus.dao.TemplatesMapper;
import top.buukle.opensource.generator.plus.dtvo.dto.templates.TemplatesQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.templates.TemplatesUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.enums.TemplatesEnums;
import top.buukle.opensource.generator.plus.dtvo.vo.templates.TemplatesVO;
import top.buukle.opensource.generator.plus.entity.Templates;
import top.buukle.opensource.generator.plus.service.TemplatesService;
import top.buukle.opensource.generator.plus.service.constants.SystemReturnEnum;
import top.buukle.opensource.generator.plus.service.exception.SystemException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description TemplatesService?????????
*/
@Service("templatesService")
public class TemplatesServiceImpl extends ServiceImpl<TemplatesMapper, Templates> implements TemplatesService<Templates, TemplatesVO, TemplatesQueryDTO, TemplatesUpdateDTO> {

    @Autowired
    TemplatesGroupService templatesGroupService;

    /**
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> add(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // ??????DTO
        Templates templates = new Templates();
        BeanUtils.copyProperties(templatesUpdateDTO,templates);
        // ????????????
        this.savePre(templates);
        templates.setStatus(TemplatesEnums.status.PUBLISHED.value());
        // ??????
        super.save(templates);
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(templates, templatesVO);
        // ??????
        return new CommonResponse.Builder().buildSuccess(templatesVO);
    }

    /**
     * @description ???or???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> addOrEdit(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // ???
        if(templatesUpdateDTO.getId() == null){
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
    public CommonResponse<TemplatesVO> deleteById(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // ????????????
        if(templatesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ??????DTO
        Templates templates = new Templates();
        BeanUtils.copyProperties(templatesUpdateDTO,templates);
        this.updatePre(templates);
        templates.setStatus(StatusConstants.DELETED);
        // ??????
        super.updateById(templates);
        // ??????
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(templates, templatesVO);
        return new CommonResponse.Builder().buildSuccess(templatesVO);
    }

    /**
     * @description ???
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> updateById(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // ????????????
        if(templatesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ??????DTO
        Templates templates = new Templates();
        BeanUtils.copyProperties(templatesUpdateDTO,templates);
        // ????????????
        this.updatePre(templates);
        // ??????
        super.updateById(templates);
        // ??????
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(templates, templatesVO);
        return new CommonResponse.Builder().buildSuccess(templatesVO);
    }

    /**
     * @description  ??? - ??????
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.Templates.TemplatesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> getById(CommonRequest<TemplatesQueryDTO> commonRequest) {
        TemplatesQueryDTO TemplatesQueryDTO = commonRequest.getBody();
        // ????????????
        if(TemplatesQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // ????????????
        TenantHelper.startTenant("templates");
        Templates one = super.getById(TemplatesQueryDTO.getId());
        // ????????????
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(one, templatesVO);
        if(one.getTemplatesGroupId() == null){
            throw new SystemException(SystemReturnEnum.TEMPLATES_INFO_GROUP_ID_NULL);
        }
        TemplatesGroup byId = (TemplatesGroup) templatesGroupService.getById(one.getTemplatesGroupId());
        if(byId == null || byId.getStatus() != status.PUBLISHED.value()){
            throw new SystemException(SystemReturnEnum.TEMPLATES_INFO_GROUP_STATUS_WRONG);
        }
        templatesVO.setTemplatesGroupName(byId.getName());
        templatesVO.setTemplatesGroupParamList(JsonUtil.parseArray(byId.getParams(), TemplatesVO.Param.class));
        CommonResponse<TemplatesVO> TemplatesQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(templatesVO);
        return TemplatesQueryVOCommonResponse;
    }

    /**
     * @description ??? - ??????
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.Templates.TemplatesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<TemplatesVO> getPage(CommonRequest<TemplatesQueryDTO> commonRequest) {
        // ??????DTO
        TemplatesQueryDTO TemplatesQueryDTO = commonRequest.getBody();
        Templates Templates = new Templates();
        BeanUtils.copyProperties(TemplatesQueryDTO,Templates);
        // ??????
        QueryWrapper<Templates> queryWrapper = this.assPageParam(TemplatesQueryDTO);
        // ??????
        PageHelper.startPage(TemplatesQueryDTO.getPageNo(),TemplatesQueryDTO.getPageSize());
        TenantHelper.startTenant("templates");
        List<Templates> list = super.list(queryWrapper);
        PageInfo<Templates> pageInfo = new PageInfo<>(list);
        // ??????
        List<TemplatesVO> queryVOList = new ArrayList<>();
        for (Templates templatesDB : list) {
            TemplatesVO templatesVO = new TemplatesVO();
            BeanUtils.copyProperties(templatesDB, templatesVO);
            TemplatesGroup byId = (TemplatesGroup) templatesGroupService.getById(templatesDB.getTemplatesGroupId());
            if(byId == null || byId.getStatus() != status.PUBLISHED.value()){
                throw new SystemException(SystemReturnEnum.TEMPLATES_INFO_GROUP_STATUS_WRONG);
            }
            templatesVO.setTemplatesGroupName(byId.getName());
            queryVOList.add(templatesVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description ??????????????????
     * @param templatesQueryDTO
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<top.buukle.generator.entity.model.Templates>
     * @Author 17600
     * @Date 2021/9/2
     */
    private QueryWrapper<Templates> assPageParam( TemplatesQueryDTO templatesQueryDTO) {
        QueryWrapper<Templates> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(templatesQueryDTO.getName())){
            queryWrapper.eq("name", templatesQueryDTO.getName());
        }
        if(StringUtil.isNotEmpty(templatesQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(templatesQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(templatesQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(templatesQueryDTO.getStartTime()));
        }
        if(templatesQueryDTO.getTemplatesGroupId() != null){
            queryWrapper.eq("templates_group_id",templatesQueryDTO.getTemplatesGroupId());
        }
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        // ??????????????? ...
        return queryWrapper;
    }

    /**
     * @description ??? - ?????????
     * @param Templates
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(Templates Templates) {
        Date date = new Date();

        UserDTO operator = SessionUtils.getOperator();

        Templates.setGmtCreated(date);
        Templates.setCreator(operator.getUsername());
        Templates.setCreatorCode(operator.getUserId());
        Templates.setTenantId(Integer.parseInt(StringUtil.isEmpty(operator.getTenantId())?"-1":operator.getTenantId()));
        Templates.setGmtModified(date);

        Templates.setModifier(operator.getUsername());
        Templates.setModifierCode(operator.getUserId());
        Templates.setStatus(TemplatesEnums.status.INIT.value());

    }

    /**
     * @description ??? - ?????????
     * @param Templates
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(Templates Templates) {

        Date date = new Date();

        UserDTO operator = SessionUtils.getOperator();

        Templates.setGmtModified(date);
        Templates.setModifier(operator.getUsername());
        Templates.setModifierCode(operator.getUserId());

    }

    /**
     * @description ??????groupId??????????????????
     * @param commonRequest
     * @return top.buukle.opensource.generator.plus.commons.call.CommonResponse<java.util.List<top.buukle.opensource.generator.plus.dos.vo.templates.TemplatesVO>>
     * @Author 17600
     * @Date 2021/10/16
     */
    @Override
    public CommonResponse<List<TemplatesVO>> getTemplatesByGroupId(CommonRequest<TemplatesQueryDTO> commonRequest) {
        QueryWrapper<Templates> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("templates_group_id",commonRequest.getBody().getTemplatesGroupId());
        queryWrapper.gt("status",StatusConstants.DELETED);
        List<Templates> list = super.list(queryWrapper);
        List<TemplatesVO> queryVOList = new ArrayList<>();
        for (Templates TemplatesDB : list) {
            TemplatesVO TemplatesVO = new TemplatesVO();
            BeanUtils.copyProperties(TemplatesDB, TemplatesVO);
            queryVOList.add(TemplatesVO);
        }
        return new CommonResponse.Builder().buildSuccess(queryVOList);
    }

    /**
     * @description ????????????????????????
     * @param templatesGroupIdSource
     * @param templatesGroupIdTarget
     * @param templatesGroupUpdateDTO
     * @return void
     * @Author zhanglei001
     * @Date 2021/11/29
     */
    @Override
    public void copyByGroupId(Integer templatesGroupIdSource, Integer templatesGroupIdTarget, TemplatesGroupUpdateDTO templatesGroupUpdateDTO) {
        QueryWrapper<Templates> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("templates_group_id",templatesGroupIdSource);
        queryWrapper.gt("status",StatusConstants.DELETED);
        List<Templates> list = super.list(queryWrapper);
        for (Templates templates : list) {
            templates.setId(null);
            templates.setTemplatesGroupId(templatesGroupIdTarget);
            Integer status = templates.getStatus();
            savePre(templates);
            templates.setStatus(status);
            if(StringUtil.isNotEmpty(templates.getPath()) && StringUtil.isNotEmpty(templatesGroupUpdateDTO.getPathToReplace1())){
                templates.setPath(templates.getPath().replace(templatesGroupUpdateDTO.getPathToReplace1(),templatesGroupUpdateDTO.getPathReplaced1() == null ? "" : templatesGroupUpdateDTO.getPathReplaced1()));
            }

            if(StringUtil.isNotEmpty(templates.getPath()) && StringUtil.isNotEmpty(templatesGroupUpdateDTO.getPathToReplace2())){
                templates.setPath(templates.getPath().replace(templatesGroupUpdateDTO.getPathToReplace2(),templatesGroupUpdateDTO.getPathReplaced2() == null ? "" : templatesGroupUpdateDTO.getPathReplaced2()));
            }

            if(StringUtil.isNotEmpty(templates.getPackageInfo()) && StringUtil.isNotEmpty(templatesGroupUpdateDTO.getPackageInfoToReplace())){
                templates.setPackageInfo(templates.getPackageInfo().replace(templatesGroupUpdateDTO.getPackageInfoToReplace(),templatesGroupUpdateDTO.getPackageInfoReplaced() == null ? "" : templatesGroupUpdateDTO.getPackageInfoReplaced()));
            }
        }
        super.saveBatch(list);
    }

    /**
     * @description ????????????id????????????
     * @param templatesGroupId
     * @return void
     * @Author zhanglei001
     * @Date 2021/11/30
     */
    @Override
    public void deleteTemplatesByGroupId(Integer templatesGroupId) {
        UpdateWrapper<Templates> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("templates_group_id",templatesGroupId);

        Date date = new Date();
        UserDTO operator = SessionUtils.getOperator();

        updateWrapper.set("gmt_modified",date);
        updateWrapper.set("modifier",operator.getUsername());
        updateWrapper.set("modifier_code",operator.getUserId());

        updateWrapper.set("status",TemplatesEnums.status.DELETED.value());

        super.update(updateWrapper);
    }
}
