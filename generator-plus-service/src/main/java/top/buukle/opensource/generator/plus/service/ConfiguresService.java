package top.buukle.opensource.generator.plus.service;

import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.mvc.service.BaseService;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface ConfiguresService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<Boolean> gen(CommonRequest<QUERYDTO> commonRequest);

}
