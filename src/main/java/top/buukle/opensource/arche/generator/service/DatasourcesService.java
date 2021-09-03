package top.buukle.opensource.arche.generator.service;

import top.buukle.opensource.arche.generator.commons.call.CommonRequest;
import top.buukle.opensource.arche.generator.commons.call.CommonResponse;
import top.buukle.opensource.arche.generator.commons.mvc.service.BaseService;

import java.sql.SQLException;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface  DatasourcesService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> testLink(CommonRequest<UPDATEDTO> commonRequest) throws SQLException;
}
