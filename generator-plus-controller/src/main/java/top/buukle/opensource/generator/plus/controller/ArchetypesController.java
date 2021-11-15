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
import top.buukle.opensource.generator.plus.dos.dto.archetypes.ArchetypesQueryDTO;
import top.buukle.opensource.generator.plus.dos.dto.archetypes.ArchetypesUpdateDTO;
import top.buukle.opensource.generator.plus.dos.dto.archetypesExecute.ArchetypesExecuteUpdateDTO;
import top.buukle.opensource.generator.plus.dos.vo.archetypes.ArchetypesVO;
import top.buukle.opensource.generator.plus.dos.vo.archetypesExecute.ArchetypesExecuteVO;
import top.buukle.opensource.generator.plus.entity.Archetypes;
import top.buukle.opensource.generator.plus.service.ArchetypesService;
import top.buukle.opensource.generator.plus.service.util.ResponseConvertUtil;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPPageResponseVO;

import java.io.IOException;

/**
 * @author elvin
 * @description  Archetypes controller
 */
@Controller
@RequestMapping("/archetypes")
@Api(value = "Archetypes",tags=" Archetypes Controller")
public class ArchetypesController {

    @Autowired
    private ArchetypesService<Archetypes, ArchetypesVO, ArchetypesQueryDTO, ArchetypesUpdateDTO> archetypesService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<ArchetypesVO> add(@RequestBody CommonRequest<ArchetypesUpdateDTO> commonRequest) throws Exception {
        return archetypesService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<ArchetypesVO> deleteById(@RequestBody CommonRequest<ArchetypesUpdateDTO> commonRequest) throws IOException {
        return archetypesService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse<ArchetypesVO> updateById(@RequestBody CommonRequest<ArchetypesUpdateDTO> commonRequest) throws Exception {
        return archetypesService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<ArchetypesVO> addOrEdit(@RequestBody CommonRequest<ArchetypesUpdateDTO> commonRequest) throws Exception {
        return archetypesService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<ArchetypesVO> getById(@RequestBody CommonRequest<ArchetypesQueryDTO> commonRequest) {
        return archetypesService.getById(commonRequest);
    }

    @PostMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<Archetypes> getPage(@RequestBody CommonRequest<ArchetypesQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(archetypesService.getPage(commonRequest));
    }

    @PostMapping("/getLastedLogById")
    @ResponseBody
    @ApiOperation(value = "获取上次使用的日志", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> getLastedLogById(@RequestBody CommonRequest<ArchetypesQueryDTO> commonRequest) throws Exception {
        return archetypesService.getLastedLogById(commonRequest);
    }
    @PostMapping("/execute")
    @ResponseBody
    @ApiOperation(value = "生成", httpMethod = "POST")
    public CommonResponse<ArchetypesExecuteVO> execute(@RequestBody CommonRequest<ArchetypesExecuteUpdateDTO> commonRequest) throws Exception {
        return archetypesService.execute(commonRequest);
    }
}