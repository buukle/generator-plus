package top.buukle.generator.commons.mvc;


import top.buukle.generator.commons.call.CommonResponse;
import top.buukle.generator.commons.call.FuzzyResponse;
import top.buukle.generator.commons.call.PageResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/4.
 * @Description :
 */
public interface BaseService {

    Object selectByPrimaryKeyForCrud(HttpServletRequest request, Integer id) ;

    PageResponse getPage(BaseQuery query) ;

    FuzzyResponse fuzzySearch(String text, String fieldName);

    CommonResponse delete(Integer id, HttpServletRequest request, HttpServletResponse response);

    CommonResponse save(BaseQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse update(BaseQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse deleteBatch(String ids, HttpServletRequest request, HttpServletResponse response);
}
