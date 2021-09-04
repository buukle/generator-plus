package top.buukle.opensource.arche.generator.service;

import top.buukle.commons.call.CommonRequest;
import top.buukle.commons.call.CommonResponse;
import top.buukle.commons.mvc.service.BaseService;
import top.buukle.opensource.arche.generator.dos.vo.tables.TableVo;

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
