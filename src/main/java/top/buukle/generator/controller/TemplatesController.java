package top.buukle.generator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.Templates;
import top.buukle.generator.entity.dto.ANTDPPageResponseDTO;
import top.buukle.generator.entity.dto.ResponseConvert;
import top.buukle.generator.entity.vo.TemplatesQuery;
import top.buukle.generator.service.TemplatesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author elvin
* @description  Templates controller
*/
@Controller
@RequestMapping("/templates")
@Api(value = "Templates",tags=" Templates Controller")
public class TemplatesController {

    @Autowired
    private TemplatesService templatesService;

    /**
    * @description 编辑回显接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/templatesCrudViewFront")
    @ResponseBody
    @ApiOperation(value = "编辑回显接口", httpMethod = "POST")
    public CommonResponse<Templates> templatesCrudViewFront(Integer id, HttpServletRequest request) {
        return new CommonResponse.Builder().buildSuccess(templatesService.selectByPrimaryKeyForCrud(request, id));
    }

    /**
     * 获取列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/templatesPageJson")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public ANTDPPageResponseDTO<TemplatesQuery> templatesPageJson(TemplatesQuery query) throws Exception {
        PageResponse<TemplatesQuery>  page = templatesService.getPage(query);
        return ResponseConvert.convert(page);
    }

    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/templatesPageFront")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public PageResponse<Templates> templatesPageFront(TemplatesQuery query) throws Exception {
        return templatesService.getPage(query);
    }

    /**
    * @description 删除单条接口接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/templatesCrudJson")
    @ResponseBody
    @ApiOperation(value = "删除单条接口", httpMethod = "POST")
    public CommonResponse templatesCrudJson( Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        templatesService.selectByPrimaryKeyForCrud(request,id);
        CommonResponse delete = templatesService.delete(id, request, response);
        return delete;
    }
    /**
    * @description 批量删除接口接口
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/templatesBatchDeleteJson")
    @ResponseBody
    @ApiOperation(value = "批量删除接口", httpMethod = "POST")
    public CommonResponse templatesBatchDeleteJson( String ids , HttpServletRequest request,HttpServletResponse response) throws IOException {
        CommonResponse commonResponse = templatesService.deleteBatch(ids, request, response);
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
        return templatesService.fuzzySearch(text, fieldName);
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
    public CommonResponse saveOrEdit(@RequestBody TemplatesQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return templatesService.saveOrEdit(query,request,response);
    }
}