package top.buukle.generator.service;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.mvc.BaseService;
import top.buukle.generator.entity.vo.ConfiguresQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author elvin
* @description ConfiguresService 接口类
*/
public interface ConfiguresService extends BaseService{

    CommonResponse saveOrEdit(ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse gen(ConfiguresQuery query, HttpServletRequest request, HttpServletResponse response) throws IOException;
}