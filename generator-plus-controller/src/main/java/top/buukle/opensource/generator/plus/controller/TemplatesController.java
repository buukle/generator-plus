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
import top.buukle.opensource.generator.plus.dtvo.dto.templates.TemplatesQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.templates.TemplatesUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.vo.templates.TemplatesVO;
import top.buukle.opensource.generator.plus.entity.Templates;
import top.buukle.opensource.generator.plus.service.TemplatesService;
import top.buukle.opensource.generator.plus.service.util.ResponseConvertUtil;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPPageResponseVO;

import java.io.IOException;
import java.util.List;

/**
 * @author elvin
 * @description  Templates controller
 */
@Controller
@RequestMapping("/templates")
@Api(value = "Templates",tags=" Templates Controller")
public class TemplatesController {

    @Autowired
    private TemplatesService<Templates, TemplatesVO, TemplatesQueryDTO, TemplatesUpdateDTO> templatesService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<TemplatesVO> add(@RequestBody CommonRequest<TemplatesUpdateDTO> commonRequest) throws Exception {
        return templatesService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<TemplatesVO> deleteById(@RequestBody CommonRequest<TemplatesUpdateDTO> commonRequest) throws IOException {
        return templatesService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse<TemplatesVO> updateById(@RequestBody CommonRequest<TemplatesUpdateDTO> commonRequest) throws Exception {
        return templatesService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<TemplatesVO> addOrEdit(@RequestBody CommonRequest<TemplatesUpdateDTO> commonRequest) throws Exception {
        return templatesService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<TemplatesVO> getById(@RequestBody CommonRequest<TemplatesQueryDTO> commonRequest) {
        return templatesService.getById(commonRequest);
    }

    @PostMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<Templates> getPage(@RequestBody CommonRequest<TemplatesQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(templatesService.getPage(commonRequest));
    }

    //
    @PostMapping("/getTemplatesByGroupId")
    @ResponseBody
    @ApiOperation(value = "查 - 根据group查模板列表", httpMethod = "POST")
    public CommonResponse<List<TemplatesVO>> getTemplatesByGroupId(@RequestBody CommonRequest<TemplatesQueryDTO> commonRequest) {
        return templatesService.getTemplatesByGroupId(commonRequest);
    }

}
