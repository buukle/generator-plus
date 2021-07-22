package top.buukle.generator.service;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.mvc.BaseService;
import top.buukle.generator.entity.vo.ConfiguresExecuteQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description ConfiguresExecuteService 接口类
*/
public interface ConfiguresExecuteService extends BaseService{

    CommonResponse saveOrEdit(ConfiguresExecuteQuery query, HttpServletRequest request, HttpServletResponse response);

    public CommonResponse updateStatus(Integer originStatus,Integer targetStatus,Integer id) ;

}