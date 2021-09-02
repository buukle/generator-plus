package top.buukle.generator.service;

import top.buukle.generator.commons.call.CommonRequest;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.mvc.service.BaseService;

import java.sql.SQLException;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface  DatasourcesService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> testLink(CommonRequest<UPDATEDTO> commonRequest) throws SQLException;
}
