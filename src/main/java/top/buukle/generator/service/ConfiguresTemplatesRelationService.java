package top.buukle.generator.service;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.mvc.BaseService;
import top.buukle.generator.entity.vo.ConfiguresTemplatesRelationQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description ConfiguresTemplatesRelationService 接口类
*/
public interface ConfiguresTemplatesRelationService extends BaseService{

    CommonResponse saveOrEdit(ConfiguresTemplatesRelationQuery query, HttpServletRequest request, HttpServletResponse response);

}