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
import top.buukle.opensource.generator.plus.dtvo.dto.datasources.DatasourcesQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.opensource.generator.plus.dtvo.vo.datasources.DatasourcesVO;
import top.buukle.opensource.generator.plus.dtvo.vo.tables.TableVo;
import top.buukle.opensource.generator.plus.entity.Datasources;
import top.buukle.opensource.generator.plus.service.DatasourcesService;
import top.buukle.opensource.generator.plus.service.util.ResponseConvertUtil;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPPageResponseVO;

import java.io.IOException;
import java.util.List;

/**
 * @author elvin
 * @description  Datasources controller
 */
@Controller
@RequestMapping("/datasources")
@Api(value = "Datasources",tags=" Datasources Controller")
public class DatasourcesController {

    @Autowired
    private DatasourcesService<Datasources, DatasourcesVO, DatasourcesQueryDTO, DatasourcesUpdateDTO> datasourcesService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<DatasourcesVO> add(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.add(commonRequest);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<DatasourcesVO> deleteById(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws IOException {
        return datasourcesService.deleteById(commonRequest);
    }

    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse<DatasourcesVO> updateById(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.updateById(commonRequest);
    }


    @PostMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<DatasourcesVO> addOrEdit(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.addOrEdit(commonRequest);
    }

    @PostMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<DatasourcesVO> getById(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) {
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

    @PostMapping("/getDatasourcesForConfigure")
    @ResponseBody
    @ApiOperation(value = "为配置详情页获取下拉列表", httpMethod = "POST")
    public CommonResponse<List<DatasourcesVO>> getDatasourcesForConfigure(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) throws Exception {
        return datasourcesService.getDatasourcesForConfigure(commonRequest);
    }

    @PostMapping("/getTablesListById")
    @ResponseBody
    @ApiOperation(value = "获取某个id数据源下的表", httpMethod = "POST")
    public CommonResponse<List<TableVo>> getTablesListById(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) throws Exception {
        return datasourcesService.getTablesListById(commonRequest);
    }

}