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
import top.buukle.generator.entity.Datasources;
import top.buukle.generator.entity.vo.antd.ANTDPPageResponseVO;
import top.buukle.generator.entity.dto.datasources.DatasourcesQueryDTO;
import top.buukle.generator.entity.vo.antd.TableVo;
import top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO;
import top.buukle.generator.service.DatasourcesService;

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
    private DatasourcesService<Datasources,DatasourcesQueryVO,DatasourcesQueryDTO> datasourcesService;

    @RequestMapping("/datasourcesCrudViewFront")
    @ResponseBody
    @ApiOperation(value = "编辑回显接口", httpMethod = "POST")
    public CommonResponse<DatasourcesQueryVO> datasourcesCrudViewFront(CommonRequest<DatasourcesQueryDTO> commonRequest) {
        datasourcesService.getById(commonRequest);
        return null;
    }

    @RequestMapping("/datasourcesPageJson")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public ANTDPPageResponseVO<Datasources> datasourcesPageJson(DatasourcesQueryDTO query) throws Exception {
        return null;
    }



    @RequestMapping("/getTables")
    @ResponseBody
    @ApiOperation(value = "获取表名列表", httpMethod = "POST")
    public PageResponse<String> getTables(DatasourcesQueryDTO query) throws Exception {
        return null;
    }

    @RequestMapping("/getTablesList")
    @ResponseBody
    @ApiOperation(value = "获取表名列表", httpMethod = "POST")
    public PageResponse<TableVo> getTablesList(DatasourcesQueryDTO query) throws Exception {
        return null;
    }


    @RequestMapping("/getDatasources")
    @ResponseBody
    @ApiOperation(value = "获取下拉框", httpMethod = "POST")
    public PageResponse<DatasourcesQueryDTO> getDatasources(DatasourcesQueryDTO query) throws Exception {
        return null;
    }


    @RequestMapping("/datasourcesCrudJson")
    @ResponseBody
    @ApiOperation(value = "删除单条接口", httpMethod = "POST")
    public CommonResponse datasourcesCrudJson( Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        return null;
    }

    @RequestMapping("/datasourcesBatchDeleteJson")
    @ResponseBody
    @ApiOperation(value = "批量删除接口", httpMethod = "POST")
    public CommonResponse datasourcesBatchDeleteJson( String ids , HttpServletRequest request,HttpServletResponse response) throws IOException {
        return null;
    }


    @RequestMapping("/saveOrEdit")
    @ResponseBody
    @ApiOperation(value = "新增或者修改提交接口", httpMethod = "POST")
    public CommonResponse saveOrEdit(@RequestBody DatasourcesQueryDTO query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @RequestMapping("/testLink")
    @ResponseBody
    @ApiOperation(value = "测试连接", httpMethod = "POST")
    public CommonResponse testLink(DatasourcesQueryDTO query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @RequestMapping("/testLinkPayload")
    @ResponseBody
    @ApiOperation(value = "测试连接", httpMethod = "POST")
    public CommonResponse testLinkPayload(@RequestBody DatasourcesQueryDTO query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}