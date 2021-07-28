/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: ResponseConvert
 * Author:   elvin
 * Date:     2021/7/26 20:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.entity.dto;

import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.entity.Datasources;
import top.buukle.generator.utils.JsonUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ResponseConvert {

    public static ANTDPPageResponseDTO convert(PageResponse page) {

        Result result = new Result().setData(page.getBody().getList());

        result.setPageNo(page.getBody().getPageNo());
        result.setPageSize(page.getBody().getPageSize());
        result.setTotalCount(page.getBody().getTotal());
        result.setTotalPage(page.getBody().getTotalPage());

        ANTDPPageResponseDTO antdpCommonResponseDTO = new ANTDPPageResponseDTO();

        antdpCommonResponseDTO.setStatus(page.getHead().getStatus().equals("S") ? 200 : 500);
        antdpCommonResponseDTO.setMessage(page.getHead().getMsg());
        antdpCommonResponseDTO.setResult(result);
        antdpCommonResponseDTO.setTimestamp(System.currentTimeMillis());

        System.out.println(JsonUtil.toJSONString(antdpCommonResponseDTO));
        return antdpCommonResponseDTO;
    }
}