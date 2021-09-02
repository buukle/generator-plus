package top.buukle.generator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.ConfiguresTemplatesRelation;
import top.buukle.generator.entity.vo.ConfiguresTemplatesRelationQuery;
import top.buukle.generator.service.ConfiguresTemplatesRelationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author elvin
* @description  ConfiguresTemplatesRelation controller
*/
@Controller
@RequestMapping("/configuresTemplatesRelation")
@Api(value = "ConfiguresTemplatesRelation",tags=" ConfiguresTemplatesRelation Controller")
public class ConfiguresTemplatesRelationController {

    @Autowired
    private ConfiguresTemplatesRelationService configuresTemplatesRelationService;

    /**
    * @description 编辑回显接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresTemplatesRelationCrudViewFront")
    @ResponseBody
    @ApiOperation(value = "编辑回显接口", httpMethod = "POST")
    public CommonResponse<ConfiguresTemplatesRelation> configuresTemplatesRelationCrudViewFront(Integer id, HttpServletRequest request) {
        return new CommonResponse.Builder().buildSuccess(configuresTemplatesRelationService.selectByPrimaryKeyForCrud(request, id));
    }


    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/configuresTemplatesRelationPageFront")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public PageResponse<ConfiguresTemplatesRelation> configuresTemplatesRelationPageFront(ConfiguresTemplatesRelationQuery query) throws Exception {
        return configuresTemplatesRelationService.getPage(query);
    }

    /**
    * @description 删除单条接口接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresTemplatesRelationCrudJson")
    @ResponseBody
    @ApiOperation(value = "删除单条接口", httpMethod = "POST")
    public CommonResponse configuresTemplatesRelationCrudJson( Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        configuresTemplatesRelationService.selectByPrimaryKeyForCrud(request,id);
        CommonResponse delete = configuresTemplatesRelationService.delete(id, request, response);
        return delete;
    }
    /**
    * @description 批量删除接口接口
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresTemplatesRelationBatchDeleteJson")
    @ResponseBody
    @ApiOperation(value = "批量删除接口", httpMethod = "POST")
    public CommonResponse configuresTemplatesRelationBatchDeleteJson( String ids , HttpServletRequest request,HttpServletResponse response) throws IOException {
        CommonResponse commonResponse = configuresTemplatesRelationService.deleteBatch(ids, request, response);
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
        return configuresTemplatesRelationService.fuzzySearch(text, fieldName);
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
    public CommonResponse saveOrEdit(ConfiguresTemplatesRelationQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return configuresTemplatesRelationService.saveOrEdit(query,request,response);
    }
}