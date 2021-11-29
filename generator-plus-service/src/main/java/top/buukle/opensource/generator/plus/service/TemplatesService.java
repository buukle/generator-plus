package top.buukle.opensource.generator.plus.service;

import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.mvc.service.BaseService;

import java.util.List;

/**
* @author elvin
* @description DatasourcesService 定制化业务接口
*/
public interface TemplatesService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<List<VO>> getTemplatesByGroupId(CommonRequest<QUERYDTO> commonRequest);

    void copyByGroupId(Integer templatesGroupIdSource, Integer templatesGroupIdTarget);
}
