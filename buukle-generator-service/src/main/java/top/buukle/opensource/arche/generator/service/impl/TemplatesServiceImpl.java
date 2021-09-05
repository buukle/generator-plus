package top.buukle.opensource.arche.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import top.buukle.opensource.arche.generator.dao.TemplatesMapper;
import top.buukle.opensource.arche.generator.dos.dto.templates.TemplatesQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.templates.TemplatesUpdateDTO;
import top.buukle.opensource.arche.generator.dos.enums.TemplatesEnums;
import top.buukle.opensource.arche.generator.dos.vo.templates.TemplatesVO;
import top.buukle.opensource.arche.generator.entity.Templates;
import top.buukle.opensource.arche.generator.service.TemplatesService;
import top.buukle.opensource.arche.generator.service.constants.SystemReturnEnum;
import top.buukle.opensource.arche.generator.service.exception.SystemException;
import top.buukle.business.base.utils.DateUtil;
import top.buukle.business.base.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description TemplatesService实现类
*/
@Service("templatesService")
public class TemplatesServiceImpl extends ServiceImpl<TemplatesMapper, Templates> implements TemplatesService<Templates, TemplatesVO, TemplatesQueryDTO, TemplatesUpdateDTO> {


    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> add(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // 转换DTO
        Templates templates = new Templates();
        BeanUtils.copyProperties(templatesUpdateDTO,templates);
        // 初始字段
        this.savePre(templates);
        templates.setStatus(TemplatesEnums.status.PUBLISHED.value());
        // 落库
        super.save(templates);
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(templates, templatesVO);
        // 返回
        return new CommonResponse.Builder().buildSuccess(templatesVO);
    }

    /**
     * @description 增or改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> addOrEdit(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // 增
        if(templatesUpdateDTO.getId() == null){
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
    public CommonResponse<TemplatesVO> deleteById(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(templatesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Templates templates = new Templates();
        BeanUtils.copyProperties(templatesUpdateDTO,templates);
        this.updatePre(templates);
        templates.setStatus(StatusConstants.DELETED);
        // 落库
        super.updateById(templates);
        // 返回
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(templates, templatesVO);
        return new CommonResponse.Builder().buildSuccess(templatesVO);
    }

    /**
     * @description 改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> updateById(CommonRequest<TemplatesUpdateDTO> commonRequest) {
        TemplatesUpdateDTO templatesUpdateDTO = commonRequest.getBody();
        // 验证参数
        if(templatesUpdateDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 转换DTO
        Templates templates = new Templates();
        BeanUtils.copyProperties(templatesUpdateDTO,templates);
        // 更新字段
        this.updatePre(templates);
        // 落库
        super.updateById(templates);
        // 返回
        TemplatesVO templatesVO = new TemplatesVO();
        BeanUtils.copyProperties(templates, templatesVO);
        return new CommonResponse.Builder().buildSuccess(templatesVO);
    }

    /**
     * @description  查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.Templates.TemplatesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public CommonResponse<TemplatesVO> getById(CommonRequest<TemplatesQueryDTO> commonRequest) {
        TemplatesQueryDTO TemplatesQueryDTO = commonRequest.getBody();
        // 验证参数
        if(TemplatesQueryDTO.getId() == null){
            throw new SystemException(SystemReturnEnum.RUD_ID_NULL);
        }
        // 执行查询
        Templates one = super.getById(TemplatesQueryDTO.getId());
        // 转换响应
        TemplatesVO TemplatesVO = new TemplatesVO();
        BeanUtils.copyProperties(one, TemplatesVO);
        CommonResponse<TemplatesVO> TemplatesQueryVOCommonResponse = new CommonResponse.Builder().buildSuccess(TemplatesVO);
        return TemplatesQueryVOCommonResponse;
    }

    /**
     * @description 查 - 分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.Templates.TemplatesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public PageResponse<TemplatesVO> getPage(CommonRequest<TemplatesQueryDTO> commonRequest) {
        // 转换DTO
        TemplatesQueryDTO TemplatesQueryDTO = commonRequest.getBody();
        Templates Templates = new Templates();
        BeanUtils.copyProperties(TemplatesQueryDTO,Templates);
        // 条件
        QueryWrapper<Templates> queryWrapper = this.assPageParam(TemplatesQueryDTO);
        // 查询
        PageHelper.startPage(TemplatesQueryDTO.getPageNo(),TemplatesQueryDTO.getPageSize());
        List<Templates> list = super.list(queryWrapper);
        PageInfo<Templates> pageInfo = new PageInfo<>(list);
        // 分页
        List<TemplatesVO> queryVOList = new ArrayList<>();
        for (Templates TemplatesDB : list) {
            TemplatesVO TemplatesVO = new TemplatesVO();
            BeanUtils.copyProperties(TemplatesDB, TemplatesVO);
            queryVOList.add(TemplatesVO);
        }
        return new PageResponse.Builder().build(queryVOList, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * @description 组装分页条件
     * @param TemplatesQueryDTO
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<top.buukle.generator.entity.model.Templates>
     * @Author 17600
     * @Date 2021/9/2
     */
    private QueryWrapper<Templates> assPageParam( TemplatesQueryDTO TemplatesQueryDTO) {
        QueryWrapper<Templates> queryWrapper = new QueryWrapper<>();
        if(StringUtil.isNotEmpty(TemplatesQueryDTO.getStartTime())){
            queryWrapper.ge("gmt_created", DateUtil.parse(TemplatesQueryDTO.getStartTime()));
        }
        if(StringUtil.isNotEmpty(TemplatesQueryDTO.getEndTime())){
            queryWrapper.le("gmt_created", DateUtil.parse(TemplatesQueryDTO.getStartTime()));
        }
        queryWrapper.gt("status",StatusConstants.DELETED);
        queryWrapper.orderByDesc("gmt_modified");
        // 可按需扩展 ...
        return queryWrapper;
    }

    /**
     * @description 增 - 初始化
     * @param Templates
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void savePre(Templates Templates) {
        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        Templates.setGmtCreated(date);
        Templates.setCreator(operator.getUsername());
        Templates.setCreatorCode(operator.getUserId());
        Templates.setCreatorDeptId(Integer.parseInt(StringUtil.isEmpty(operator.getDeptId())?"-1":operator.getDeptId()));
        Templates.setGmtModified(date);

        Templates.setModifier(operator.getUsername());
        Templates.setModifierCode(operator.getUserId());
        Templates.setStatus(TemplatesEnums.status.INIT.value());

    }

    /**
     * @description 改 - 初始化
     * @param Templates
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    @Override
    public void updatePre(Templates Templates) {

        Date date = new Date();

        UserDO operator = SessionUtils.getOperator();

        Templates.setGmtModified(date);
        Templates.setModifier(operator.getUsername());
        Templates.setModifierCode(operator.getUserId());

    }
}