package top.buukle.generator.commons.mvc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.buukle.generator.commons.call.CommonRequest;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.dto.datasources.DatasourcesUpdateDTO;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/4.
 * @Description : 通用业务接口
 */
public interface BaseService<MODEL, VO, QUERYDTO,UPDATEDTO> extends IService<MODEL> {

    CommonResponse<Boolean> add(CommonRequest<UPDATEDTO> commonRequest);

    CommonResponse<Boolean> addOrEdit(CommonRequest<UPDATEDTO> commonRequest);

    CommonResponse<Boolean> deleteById(CommonRequest<UPDATEDTO> commonRequest);

    CommonResponse<Boolean> updateById(CommonRequest<UPDATEDTO> commonRequest);

    CommonResponse<VO> getById(CommonRequest<QUERYDTO> commonRequest) ;

    PageResponse<VO> getPage(CommonRequest<QUERYDTO> commonRequest) ;

    void saveInit(MODEL MODEL);

    void updateInit(MODEL MODEL);

}
