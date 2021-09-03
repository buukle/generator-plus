package top.buukle.opensource.arche.generator.commons.mvc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.buukle.opensource.arche.generator.commons.call.CommonRequest;
import top.buukle.opensource.arche.generator.commons.call.CommonResponse;
import top.buukle.opensource.arche.generator.commons.call.PageResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/4.
 * @Description : 通用业务接口
 */
public interface BaseService<MODEL, VO, QUERYDTO,UPDATEDTO> extends IService<MODEL> {


    /**
     * @description 增
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    CommonResponse<Boolean> add(CommonRequest<UPDATEDTO> commonRequest);

    /**
     * @description 增or改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    CommonResponse<Boolean> addOrEdit(CommonRequest<UPDATEDTO> commonRequest);

    /**
     * @description 删
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    CommonResponse<Boolean> deleteById(CommonRequest<UPDATEDTO> commonRequest);

    /**
     * @description 改
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<java.lang.Boolean>
     * @Author 17600
     * @Date 2021/9/2
     */
    CommonResponse<Boolean> updateById(CommonRequest<UPDATEDTO> commonRequest);

    /**
     * @description  查 - 单条
     * @param commonRequest
     * @return top.buukle.generator.commons.call.CommonResponse<top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    CommonResponse<VO> getById(CommonRequest<QUERYDTO> commonRequest) ;

    /**
     * @description 查 - 分页
     * @param commonRequest
     * @return top.buukle.generator.commons.call.PageResponse<top.buukle.generator.entity.vo.datasources.DatasourcesQueryVO>
     * @Author 17600
     * @Date 2021/9/2
     */
    PageResponse<VO> getPage(CommonRequest<QUERYDTO> commonRequest) ;

    /**
     * @description 增 - 初始化
     * @param MODEL
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    void savePre(MODEL MODEL);

    /**
     * @description 改 - 初始化
     * @param MODEL
     * @return void
     * @Author 17600
     * @Date 2021/9/2
     */
    void updatePre(MODEL MODEL);

}
