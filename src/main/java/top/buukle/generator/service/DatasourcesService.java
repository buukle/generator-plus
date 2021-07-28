package top.buukle.generator.service;

import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.commons.mvc.BaseService;
import top.buukle.generator.entity.vo.DatasourcesQuery;
import top.buukle.generator.entity.vo.TableVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
* @author elvin
* @description DatasourcesService 接口类
*/
public interface DatasourcesService extends BaseService{

    CommonResponse saveOrEdit(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse testLink(DatasourcesQuery query, HttpServletRequest request, HttpServletResponse response) throws SQLException;

    PageResponse<DatasourcesQuery> getDatasources(DatasourcesQuery query);

    PageResponse<String> getTables(DatasourcesQuery query) throws SQLException;

    PageResponse<TableVo> getTablesList(DatasourcesQuery query) throws SQLException;

}
