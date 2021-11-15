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
import top.buukle.opensource.generator.plus.dos.dto.configuresExecute.ConfiguresExecuteQueryDTO;
import top.buukle.opensource.generator.plus.dos.dto.configuresExecute.ConfiguresExecuteUpdateDTO;
import top.buukle.opensource.generator.plus.dos.vo.configuresExecute.ConfiguresExecuteVO;
import top.buukle.opensource.generator.plus.entity.ConfiguresExecute;
import top.buukle.opensource.generator.plus.service.ConfiguresExecuteService;
import top.buukle.opensource.generator.plus.service.util.ResponseConvertUtil;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPPageResponseVO;

import java.io.IOException;

/**
 * @author elvin
 * @description  ConfiguresExecute controller
 */
@Controller
@RequestMapping("/configuresExecute")
@Api(value = "ConfiguresExecute",tags=" ConfiguresExecute Controller")
public class ConfiguresExecuteController {

    @Autowired
    private ConfiguresExecuteService<ConfiguresExecute, ConfiguresExecuteVO, ConfiguresExecuteQueryDTO, ConfiguresExecuteUpdateDTO> configuresExecuteService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<ConfiguresExecuteVO> add(@RequestBody CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) throws Exception {
        return configuresExecuteService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<ConfiguresExecuteVO> deleteById(@RequestBody CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) throws IOException {
        return configuresExecuteService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse<ConfiguresExecuteVO> updateById(@RequestBody CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) throws Exception {
        return configuresExecuteService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<ConfiguresExecuteVO> addOrEdit(@RequestBody CommonRequest<ConfiguresExecuteUpdateDTO> commonRequest) throws Exception {
        return configuresExecuteService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<ConfiguresExecuteVO> getById(@RequestBody CommonRequest<ConfiguresExecuteQueryDTO> commonRequest) {
        return configuresExecuteService.getById(commonRequest);
    }

    @PostMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<ConfiguresExecute> getPage(@RequestBody CommonRequest<ConfiguresExecuteQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(configuresExecuteService.getPage(commonRequest));
    }

}