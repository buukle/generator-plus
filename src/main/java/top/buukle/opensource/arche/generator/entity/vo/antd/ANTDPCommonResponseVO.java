/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: ANTDPCommonResponseDTO
 * Author:   elvin
 * Date:     2021/7/26 18:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.arche.generator.entity.vo.antd;

import lombok.Data;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
@Data
public class ANTDPCommonResponseVO<T>{

    private T result;
    private String status;
    private String message;
}