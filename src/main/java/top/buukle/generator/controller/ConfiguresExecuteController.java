package top.buukle.generator.controller;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.ConfiguresExecute;
import top.buukle.generator.entity.dto.ANTDPPageResponseDTO;
import top.buukle.generator.entity.dto.ResponseConvert;
import top.buukle.generator.entity.vo.ConfiguresExecuteQuery;
import top.buukle.generator.service.ConfiguresExecuteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ConfiguresExecuteService configuresExecuteService;

    /**
    * @description 编辑回显接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresExecuteCrudViewFront")
    @ResponseBody
    @ApiOperation(value = "编辑回显接口", httpMethod = "POST")
    public CommonResponse<ConfiguresExecute> configuresExecuteCrudViewFront(Integer id, HttpServletRequest request) {
        return new CommonResponse.Builder().buildSuccess(configuresExecuteService.selectByPrimaryKeyForCrud(request, id));
    }

    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/configuresExecutePageFront")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public PageResponse<ConfiguresExecute> configuresExecutePageFront(ConfiguresExecuteQuery query) throws Exception {
        return configuresExecuteService.getPage(query);
    }

    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/configuresExecutePageJson")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public ANTDPPageResponseDTO<ConfiguresExecute> configuresExecutePageJson(ConfiguresExecuteQuery query) throws Exception {
        PageResponse page = configuresExecuteService.getPage(query);
        return ResponseConvert.convert(page);

    }

    /**
    * @description 删除单条接口接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresExecuteCrudJson")
    @ResponseBody
    @ApiOperation(value = "删除单条接口", httpMethod = "POST")
    public CommonResponse configuresExecuteCrudJson( Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        configuresExecuteService.selectByPrimaryKeyForCrud(request,id);
        CommonResponse delete = configuresExecuteService.delete(id, request, response);
        return delete;
    }
    /**
    * @description 批量删除接口接口
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresExecuteBatchDeleteJson")
    @ResponseBody
    @ApiOperation(value = "批量删除接口", httpMethod = "POST")
    public CommonResponse configuresExecuteBatchDeleteJson( String ids , HttpServletRequest request,HttpServletResponse response) throws IOException {
        CommonResponse commonResponse = configuresExecuteService.deleteBatch(ids, request, response);
        return commonResponse;
    }

    /**
    * @description 模糊搜索接口接口
    * @param text
    * @param fieldName
    * @param request
    * @Author elvin
    * @Date 2019/8/4
    */
    @RequestMapping("/fuzzy/search")
    @ResponseBody
    @ApiOperation(value = "模糊搜索接口", httpMethod = "POST")
    public FuzzyResponse fuzzySearch(String text, String fieldName, HttpServletRequest request) {
        return configuresExecuteService.fuzzySearch(text, fieldName);
    }

    /**
    * @description 新增或者修改提交接口提交接口
    * @param query
    * @param request
    * @return top.buukle.common.call.CommonResponse
    * @Author elvin
    * @Date 2019/8/5
    */
    @RequestMapping("/saveOrEdit")
    @ResponseBody
    @ApiOperation(value = "新增或者修改提交接口", httpMethod = "POST")
    public CommonResponse saveOrEdit(ConfiguresExecuteQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return configuresExecuteService.saveOrEdit(query,request,response);
    }

}