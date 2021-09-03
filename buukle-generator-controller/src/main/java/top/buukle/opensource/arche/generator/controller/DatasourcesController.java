package top.buukle.opensource.arche.generator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.commons.call.CommonRequest;
import top.buukle.commons.call.CommonResponse;
import top.buukle.opensource.arche.generator.entity.model.Datasources;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.opensource.arche.generator.service.vo.antd.ANTDPPageResponseVO;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesQueryVO;
import top.buukle.opensource.arche.generator.service.DatasourcesService;
import top.buukle.opensource.arche.generator.service.util.ResponseConvertUtil;

import java.io.IOException;

/**
 * @author elvin
 * @description  Datasources controller
 */
@Controller
@RequestMapping("/datasources")
@Api(value = "Datasources",tags=" Datasources Controller")
public class DatasourcesController {

    @Autowired
    private DatasourcesService<Datasources, DatasourcesQueryVO, DatasourcesQueryDTO, DatasourcesUpdateDTO> datasourcesService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<Boolean> add(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<Boolean> deleteById(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws IOException {
        return datasourcesService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse updateById(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<Boolean> addOrEdit(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<DatasourcesQueryVO> getById(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) {
        return datasourcesService.getById(commonRequest);
    }

    @PostMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<Datasources> getPage(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(datasourcesService.getPage(commonRequest));
    }

    /*------------------------------------------------------↑↑↑↑通用可定制代码↑↑↑↑-------------------------------------------------------------*/

    @PostMapping("/testLink")
    @ResponseBody
    @ApiOperation(value = "测试数据源链接", httpMethod = "POST")
    public CommonResponse<Boolean> testLink(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.testLink(commonRequest);
    }

}