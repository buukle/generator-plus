package top.buukle.opensource.generator.plus.service;

import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.mvc.service.BaseService;
import top.buukle.opensource.generator.plus.dos.dto.archetypesExecute.ArchetypesExecuteUpdateDTO;
import top.buukle.opensource.generator.plus.dos.vo.archetypesExecute.ArchetypesExecuteVO;

/**
* @author elvin
* @description Archetypes 定制化业务接口
*/
public interface  ArchetypesService<MODEL, VO,QUERYDTO,UPDATEDTO> extends BaseService<MODEL, VO,QUERYDTO,UPDATEDTO> {

    CommonResponse<ArchetypesExecuteVO> execute(CommonRequest<ArchetypesExecuteUpdateDTO> commonRequest) throws Exception;

    CommonResponse<ArchetypesExecuteVO> getLastedLogById(CommonRequest<QUERYDTO> commonRequest);

}
