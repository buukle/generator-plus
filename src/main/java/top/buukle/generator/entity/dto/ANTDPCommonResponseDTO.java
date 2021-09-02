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
package top.buukle.generator.entity.dto;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ANTDPCommonResponseDTO <T>{

    private T result;
    private String status;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}