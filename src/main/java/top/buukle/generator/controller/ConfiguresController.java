package top.buukle.generator.controller;

import org.springframework.web.bind.annotation.RequestBody;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.Configures;
import top.buukle.generator.entity.dto.ANTDPPageResponseDTO;
import top.buukle.generator.entity.dto.ResponseConvert;
import top.buukle.generator.entity.vo.ConfiguresQuery;
import top.buukle.generator.service.ConfiguresService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author elvin
* @description  Configures controller
*/
@Controller
@RequestMapping("/configures")
@Api(value = "Configures",tags=" Configures Controller")
public class ConfiguresController {

    @Autowired
    private ConfiguresService configuresService;

    /**
    * @description 二级页面
    * @param modelAndView
    * @return org.springframework.web.servlet.ModelAndView
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresHome")
    @ApiIgnore
    public ModelAndView configuresHome(ModelAndView modelAndView) {
        modelAndView.setViewName("configures/configuresHome");
        return modelAndView;
    }

    /**
    * @description 增改页面
    * @param id
    * @param request
    * @param modelAndView
    * @return org.springframework.web.servlet.ModelAndView
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresCrudView")
    @ApiIgnore
    public ModelAndView configuresCrudView( Integer id, HttpServletRequest request, ModelAndView modelAndView) {
        Object o = configuresService.selectByPrimaryKeyForCrud(request, id);
        modelAndView.addObject("record",o);
        modelAndView.setViewName("configures/configuresCrudView");
        return modelAndView;
    }

    /**
    * @description 编辑回显接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresCrudViewFront")
    @ResponseBody
    @ApiOperation(value = "编辑回显接口", httpMethod = "POST")
    public CommonResponse<Configures> configuresCrudViewFront(Integer id, HttpServletRequest request) {
        return new CommonResponse.Builder().buildSuccess(configuresService.selectByPrimaryKeyForCrud(request, id));
    }



    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/configuresPage")
    @ApiIgnore
    public ModelAndView configuresPage( ConfiguresQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", configuresService.getPage(query));
        modelAndView.setViewName("configures/configuresPage");
        return modelAndView;
    }

    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/configuresPageFront")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public PageResponse<Configures> configuresPageFront(ConfiguresQuery query) throws Exception {
        return configuresService.getPage(query);
    }

    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/configuresPageJson")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public ANTDPPageResponseDTO<Configures> configuresPageJson(ConfiguresQuery query) throws Exception {
        PageResponse page = configuresService.getPage(query);
        return  ResponseConvert.convert(page);
    }

    /**
    * @description 删除单条接口接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresCrudJson")
    @ResponseBody
    @ApiOperation(value = "删除单条接口", httpMethod = "POST")
    public CommonResponse configuresCrudJson( Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        //configuresService.selectByPrimaryKeyForCrud(request,id);
        CommonResponse delete = configuresService.delete(id, request, response);
        return delete;
    }
    /**
    * @description 批量删除接口接口
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/configuresBatchDeleteJson")
    @ResponseBody
    @ApiOperation(value = "批量删除接口", httpMethod = "POST")
    public CommonResponse configuresBatchDeleteJson( String ids , HttpServletRequest request,HttpServletResponse response) throws IOException {
        CommonResponse commonResponse = configuresService.deleteBatch(ids, request, response);
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
        return configuresService.fuzzySearch(text, fieldName);
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
    public CommonResponse saveOrEdit(@RequestBody ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return configuresService.saveOrEdit(query,request,response);
    }

    /**
     * @description 开始生成
     * @param query
     * @param request
     * @param response
     * @return top.buukle.generator.commons.call.CommonResponse
     * @Author elvin
     * @Date 2021/5/12
     */
    @RequestMapping("/gen")
    @ResponseBody
    @ApiOperation(value = "生成", httpMethod = "POST")
    public CommonResponse gen(@RequestBody ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return configuresService.gen(query,request,response);
    }
}