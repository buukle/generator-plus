package top.buukle.opensource.arche.generator.service;

import top.buukle.commons.call.CommonRequest;
import top.buukle.commons.call.CommonResponse;
import top.buukle.commons.mvc.service.BaseService;

import java.sql.SQLException;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface  DatasourcesService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> testLink(CommonRequest<UPDATEDTO> commonRequest) throws SQLException;
}
