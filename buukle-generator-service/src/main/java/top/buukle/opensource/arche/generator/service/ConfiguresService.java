package top.buukle.opensource.arche.generator.service;

import top.buukle.business.base.commons.call.CommonRequest;
import top.buukle.business.base.commons.call.CommonResponse;
import top.buukle.business.base.commons.mvc.service.BaseService;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface ConfiguresService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> gen(CommonRequest<QUERYDTO> commonRequest);

}
