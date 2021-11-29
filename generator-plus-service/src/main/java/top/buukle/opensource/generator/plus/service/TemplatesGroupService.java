package top.buukle.opensource.generator.plus.service;

import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.mvc.service.BaseService;

import java.sql.SQLException;
import java.util.List;

/**
* @author elvin
* @description TemplatesGroup 定制化业务接口
*/
public interface  TemplatesGroupService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<List<VO>> getTemplatesGroupList(CommonRequest<QUERYDTO> commonRequest);

    CommonResponse<VO> copyWithTemplates(CommonRequest<UPDATEDTO> commonRequest);
}
