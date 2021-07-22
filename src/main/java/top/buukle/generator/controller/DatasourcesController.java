package top.buukle.generator.controller;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.Datasources;
import top.buukle.generator.entity.vo.DatasourcesQuery;
import top.buukle.generator.service.DatasourcesService;
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
* @description  Datasources controller
*/
@Controller
@RequestMapping("/datasources")
@Api(value = "Datasources",tags=" Datasources Controller")
public class DatasourcesController {

    @Autowired
    private DatasourcesService datasourcesService;

    /**
    * @description 二级页面
    * @param modelAndView
    * @return org.springframework.web.servlet.ModelAndView
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/datasourcesHome")
    @ApiIgnore
    public ModelAndView datasourcesHome(ModelAndView modelAndView) {
        modelAndView.setViewName("datasources/datasourcesHome");
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
    @RequestMapping("/datasourcesCrudView")
    @ApiIgnore
    public ModelAndView datasourcesCrudView( Integer id, HttpServletRequest request, ModelAndView modelAndView) {
        Object o = datasourcesService.selectByPrimaryKeyForCrud(request, id);
        modelAndView.addObject("record",o);
        modelAndView.setViewName("datasources/datasourcesCrudView");
        return modelAndView;
    }

    /**
    * @description 编辑回显接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/datasourcesCrudViewFront")
    @ResponseBody
    @ApiOperation(value = "编辑回显接口", httpMethod = "POST")
    public CommonResponse<Datasources> datasourcesCrudViewFront(Integer id, HttpServletRequest request) {
        return new CommonResponse.Builder().buildSuccess(datasourcesService.selectByPrimaryKeyForCrud(request, id));
    }



    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/datasourcesPage")
    @ApiIgnore
    public ModelAndView datasourcesPage( DatasourcesQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", datasourcesService.getPage(query));
        modelAndView.setViewName("datasources/datasourcesPage");
        return modelAndView;
    }

    /**
    * 获取列表接口
    * @return
    * @throws Exception
    */
    @RequestMapping("/datasourcesPageFront")
    @ResponseBody
    @ApiOperation(value = "获取列表接口", httpMethod = "POST")
    public PageResponse<Datasources> datasourcesPageFront(DatasourcesQuery query) throws Exception {
        return datasourcesService.getPage(query);
    }

    /**
    * 获取表名列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getTables")
    @ResponseBody
    @ApiOperation(value = "获取表名列表", httpMethod = "POST")
    public PageResponse<String> getTables(DatasourcesQuery query) throws Exception {
        return datasourcesService.getTables(query);
    }

    /**
    * 获取下拉框
    * @return
    * @throws Exception
    */
    @RequestMapping("/getDatasources")
    @ResponseBody
    @ApiOperation(value = "获取下拉框", httpMethod = "POST")
    public PageResponse<DatasourcesQuery> getDatasources(DatasourcesQuery query) throws Exception {
        return datasourcesService.getDatasources(query);
    }

    /**
    * @description 删除单条接口接口
    * @param id
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/datasourcesCrudJson")
    @ResponseBody
    @ApiOperation(value = "删除单条接口", httpMethod = "POST")
    public CommonResponse datasourcesCrudJson( Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        datasourcesService.selectByPrimaryKeyForCrud(request,id);
        CommonResponse delete = datasourcesService.delete(id, request, response);
        return delete;
    }
    /**
    * @description 批量删除接口接口
    * @param request
    * @Author elvin
    * @Date 2019/12/25
    */
    @RequestMapping("/datasourcesBatchDeleteJson")
    @ResponseBody
    @ApiOperation(value = "批量删除接口", httpMethod = "POST")
    public CommonResponse datasourcesBatchDeleteJson( String ids , HttpServletRequest request,HttpServletResponse response) throws IOException {
        CommonResponse commonResponse = datasourcesService.deleteBatch(ids, request, response);
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
        return datasourcesService.fuzzySearch(text, fieldName);
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
    public CommonResponse saveOrEdit(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return datasourcesService.saveOrEdit(query,request,response);
    }

    @RequestMapping("/testLink")
    @ResponseBody
    @ApiOperation(value = "测试连接", httpMethod = "POST")
    public CommonResponse testLink(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return datasourcesService.testLink(query,request,response);
    }
}