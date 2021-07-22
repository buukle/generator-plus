package top.buukle.generator.service;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.mvc.BaseService;
import top.buukle.generator.entity.vo.TemplatesQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description TemplatesService 接口类
*/
public interface TemplatesService extends BaseService{

    CommonResponse saveOrEdit(TemplatesQuery query, HttpServletRequest request, HttpServletResponse response);

}