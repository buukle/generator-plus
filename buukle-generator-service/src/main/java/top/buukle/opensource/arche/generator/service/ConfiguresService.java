package top.buukle.opensource.arche.generator.service;

import top.buukle.commons.call.CommonRequest;
import top.buukle.commons.call.CommonResponse;
import top.buukle.commons.mvc.service.BaseService;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface ConfiguresService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> gen(CommonRequest<QUERYDTO> commonRequest);

}
