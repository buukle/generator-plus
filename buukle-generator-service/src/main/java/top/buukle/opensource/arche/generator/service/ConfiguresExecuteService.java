package top.buukle.opensource.arche.generator.service;

import top.buukle.business.base.commons.mvc.service.BaseService;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface ConfiguresExecuteService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    void updateStatus(Integer originStatus,Integer targetStatus,Integer id) ;

}
