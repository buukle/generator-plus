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
package top.buukle.generator.service.util;

import top.buukle.generator.commons.call.PageResponse;
import top.buukle.generator.commons.log.BaseLogger;
import top.buukle.generator.entity.vo.antd.ANTDPPageResponseVO;
import top.buukle.generator.entity.vo.antd.ResultVO;
import top.buukle.generator.utils.JsonUtil;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ResponseConvertUtil {

    private final static BaseLogger LOGGER = BaseLogger.getLogger(ResponseConvertUtil.class);


    public static ANTDPPageResponseVO convert(PageResponse page) {

        ResultVO resultVO = new ResultVO(page.getBody().getList());

        resultVO.setPageNo(page.getBody().getPageNo());
        resultVO.setPageSize(page.getBody().getPageSize());
        resultVO.setTotalCount(page.getBody().getTotal());
        resultVO.setTotalPage(page.getBody().getTotalPage());

        ANTDPPageResponseVO antdpCommonResponseDTO = new ANTDPPageResponseVO();

        antdpCommonResponseDTO.setStatus(page.getHead().getStatus().equals("S") ? 200 : 500);
        antdpCommonResponseDTO.setMessage(page.getHead().getMsg());
        antdpCommonResponseDTO.setResult(resultVO);
        antdpCommonResponseDTO.setTimestamp(System.currentTimeMillis());

        LOGGER.info(JsonUtil.toJSONString(antdpCommonResponseDTO));
        return antdpCommonResponseDTO;
    }
}