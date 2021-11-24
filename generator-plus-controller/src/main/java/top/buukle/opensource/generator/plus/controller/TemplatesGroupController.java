package top.buukle.opensource.generator.plus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.templatesGroup.TemplatesGroupUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.vo.templatesGroup.TemplatesGroupVO;
import top.buukle.opensource.generator.plus.entity.TemplatesGroup;
import top.buukle.opensource.generator.plus.service.TemplatesGroupService;
import top.buukle.opensource.generator.plus.service.util.ResponseConvertUtil;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPPageResponseVO;

import java.io.IOException;
import java.util.List;

/**
 * @author elvin
 * @description  TemplatesGroup controller
 */
@Controller
@RequestMapping("/templatesGroup")
@Api(value = "TemplatesGroup",tags=" TemplatesGroup Controller")
public class TemplatesGroupController {

    @Autowired
    private TemplatesGroupService<TemplatesGroup, TemplatesGroupVO, TemplatesGroupQueryDTO, TemplatesGroupUpdateDTO> templatesGroupService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<TemplatesGroupVO> add(@RequestBody CommonRequest<TemplatesGroupUpdateDTO> commonRequest) throws Exception {
        return templatesGroupService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<TemplatesGroupVO> deleteById(@RequestBody CommonRequest<TemplatesGroupUpdateDTO> commonRequest) throws IOException {
        return templatesGroupService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse<TemplatesGroupVO> updateById(@RequestBody CommonRequest<TemplatesGroupUpdateDTO> commonRequest) throws Exception {
        return templatesGroupService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<TemplatesGroupVO> addOrEdit(@RequestBody CommonRequest<TemplatesGroupUpdateDTO> commonRequest) throws Exception {
        return templatesGroupService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<TemplatesGroupVO> getById(@RequestBody CommonRequest<TemplatesGroupQueryDTO> commonRequest) {
        return templatesGroupService.getById(commonRequest);
    }

    @PostMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<TemplatesGroup> getPage(@RequestBody CommonRequest<TemplatesGroupQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(templatesGroupService.getPage(commonRequest));
    }

    @PostMapping("/getTemplatesGroupList")
    @ResponseBody
    @ApiOperation(value = "查 - 当前用户可见的模板分组", httpMethod = "POST")
    public CommonResponse<List<TemplatesGroupVO>> getTemplatesGroupList(@RequestBody CommonRequest<TemplatesGroupQueryDTO> commonRequest) throws Exception {
        return templatesGroupService.getTemplatesGroupList(commonRequest);
    }

}