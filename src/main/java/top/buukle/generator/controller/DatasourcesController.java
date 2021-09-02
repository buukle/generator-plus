package top.buukle.generator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.generator.commons.call.CommonRequest;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.model.Datasources;
import top.buukle.generator.entity.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.generator.entity.vo.antd.ANTDPPageResponseVO;
import top.buukle.generator.entity.dto.datasources.DatasourcesQueryDTO;
import top.buukle.generator.entity.vo.antd.TableVo;
import top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO;
import top.buukle.generator.service.DatasourcesService;
import top.buukle.generator.service.util.ResponseConvertUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private DatasourcesService<Datasources,DatasourcesQueryVO,DatasourcesQueryDTO, DatasourcesUpdateDTO> datasourcesService;

    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "增", httpMethod = "POST")
    public CommonResponse<Boolean> add(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.add(commonRequest);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "删", httpMethod = "POST")
    public CommonResponse<Boolean> deleteById(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws IOException {
        return datasourcesService.deleteById(commonRequest);
    }

    @RequestMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "改", httpMethod = "POST")
    public CommonResponse updateById(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.updateById(commonRequest);
    }


    @RequestMapping("/addOrEdit")
    @ResponseBody
    @ApiOperation(value = "增or改", httpMethod = "POST")
    public CommonResponse<Boolean> addOrEdit(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.addOrEdit(commonRequest);
    }

    @RequestMapping("/getById")
    @ResponseBody
    @ApiOperation(value = "查 - 单条", httpMethod = "POST")
    public CommonResponse<DatasourcesQueryVO> getById(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) {
        return datasourcesService.getById(commonRequest);
    }

    @RequestMapping("/getPage")
    @ResponseBody
    @ApiOperation(value = "查 - 分页", httpMethod = "POST")
    public ANTDPPageResponseVO<Datasources> getPage(@RequestBody CommonRequest<DatasourcesQueryDTO> commonRequest) throws Exception {
        return ResponseConvertUtil.convert(datasourcesService.getPage(commonRequest));
    }

    /*------------------------------------------------------↑↑↑↑通用可定制代码↑↑↑↑-------------------------------------------------------------*/

    @RequestMapping("/testLink")
    @ResponseBody
    @ApiOperation(value = "测试数据源链接", httpMethod = "POST")
    public CommonResponse<Boolean> testLink(@RequestBody CommonRequest<DatasourcesUpdateDTO> commonRequest) throws Exception {
        return datasourcesService.testLink(commonRequest);
    }

}