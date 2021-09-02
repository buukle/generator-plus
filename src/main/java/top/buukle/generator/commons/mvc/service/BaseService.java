package top.buukle.generator.commons.mvc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.buukle.generator.commons.call.CommonRequest;
import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.PageResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/4.
 * @Description : 通用业务接口
 */
public interface BaseService<MODEL, VO,DTO> extends IService<MODEL> {

    CommonResponse<Boolean> save(CommonRequest<DTO> commonRequest);

    CommonResponse<Boolean> delete(CommonRequest<DTO> commonRequest);

    CommonResponse<Boolean> updateById(CommonRequest<DTO> commonRequest);

    CommonResponse<VO> getById(CommonRequest<DTO> commonRequest) ;

    PageResponse<VO> getPage(CommonRequest<DTO> commonRequest) ;

    void saveInit(MODEL MODEL);

    void updateInit(MODEL MODEL);

}
