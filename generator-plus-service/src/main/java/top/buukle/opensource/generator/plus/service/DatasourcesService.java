package top.buukle.opensource.generator.plus.service;

import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.mvc.service.BaseService;
import top.buukle.opensource.generator.plus.dtvo.vo.tables.TableVo;

import java.sql.SQLException;
import java.util.List;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface  DatasourcesService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> testLink(CommonRequest<UPDATEDTO> commonRequest) throws SQLException;

    CommonResponse<List<VO>> getDatasourcesForConfigure(CommonRequest<QUERYDTO> commonRequest);

    CommonResponse<List<TableVo>> getTablesListById(CommonRequest<QUERYDTO> commonRequest) throws SQLException;
}
