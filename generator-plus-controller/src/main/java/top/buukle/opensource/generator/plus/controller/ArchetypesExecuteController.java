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
import top.buukle.opensource.generator.plus.dos.dto.archetypesExecute.ArchetypesExecuteQueryDTO;
import top.buukle.opensource.generator.plus.dos.dto.archetypesExecute.ArchetypesExecuteUpdateDTO;
import top.buukle.opensource.generator.plus.dos.vo.archetypesExecute.ArchetypesExecuteVO;
import top.buukle.opensource.generator.plus.entity.ArchetypesExecute;
import top.buukle.opensource.generator.plus.service.ArchetypesExecuteService;
import top.buukle.opensource.generator.plus.service.util.ResponseConvertUtil;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPPageResponseVO;

import java.io.IOException;

/**
 * @author elvin
 * @description  ArchetypesExecute controller
 */
@Controller
@RequestMapping("/archetypesExecute")
@Api(value = "ArchetypesExecute",tags=" ArchetypesExecute Controller")
public class ArchetypesExecuteController {

    @Autowired
    private ArchetypesExecuteService<ArchetypesExecute, ArchetypesExecuteVO, ArchetypesExecuteQueryDTO, ArchetypesExecuteUpdateDTO> archetypesExecuteService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> add(@RequestBody CommonRequest<ArchetypesExecuteUpdateDTO> commonRequest) throws Exception {
        return archetypesExecuteService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> deleteById(@RequestBody CommonRequest<ArchetypesExecuteUpdateDTO> commonRequest) throws IOException {
        return archetypesExecuteService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> updateById(@RequestBody CommonRequest<ArchetypesExecuteUpdateDTO> commonRequest) throws Exception {
        return archetypesExecuteService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> addOrEdit(@RequestBody CommonRequest<ArchetypesExecuteUpdateDTO> commonRequest) throws Exception {
        return archetypesExecuteService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> getById(@RequestBody CommonRequest<ArchetypesExecuteQueryDTO> commonRequest) {
        return archetypesExecuteService.getById(commonRequest);
    }

    @PostMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<ArchetypesExecute> getPage(@RequestBody CommonRequest<ArchetypesExecuteQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(archetypesExecuteService.getPage(commonRequest));
    }


}