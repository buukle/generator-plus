/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: RequestHead
 * Author:   zhanglei1102
 * Date:     2019/7/26 15:38
 * Description: 请求头
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.commons.call.head;

import lombok.Data;
import top.buukle.opensource.generator.plus.commons.call.code.BaseReturnEnum;
import top.buukle.opensource.generator.plus.commons.exception.CommonException;

/**
 * @description 〈请求头〉
 * @author zhanglei1102
 * @create 2019/7/26
 * @since 1.0.0
 */
@Data
public class ResponseHead extends Head {

    /** 接口返回状态码*/
    private String status;
    /** 接口返回码*/
    private String code;
    /** 返回信息*/
    private String msg;

    public static class Builder{
        public ResponseHead buildSuccess() {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(BaseReturnEnum.SUCCESS.getStatus());
            responseHead.setCode(BaseReturnEnum.SUCCESS.getCode());
            responseHead.setMsg(BaseReturnEnum.SUCCESS.getMsg());
            responseHead.setOperationTime(System.currentTimeMillis() + "");
            return responseHead;
        }
        public ResponseHead buildFailedInner(CommonException commonException) {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(commonException.getStatus());
            responseHead.setCode(commonException.getCode());
            responseHead.setMsg(commonException.getMsg());
            responseHead.setOperationTime(System.currentTimeMillis() + "");
            return responseHead;
        }
        public ResponseHead buildFailed(Exception exception) {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(BaseReturnEnum.FAILED.getStatus());
            responseHead.setCode(BaseReturnEnum.FAILED.getCode());
            responseHead.setMsg(BaseReturnEnum.FAILED.getMsg() + (null == exception.getCause()? "" : exception.getCause()) + exception.getMessage());
            responseHead.setOperationTime(System.currentTimeMillis() + "");
            return responseHead;
        }
        public ResponseHead buildFailed(String msg) {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(BaseReturnEnum.FAILED.getStatus());
            responseHead.setCode(BaseReturnEnum.FAILED.getCode());
            responseHead.setMsg(BaseReturnEnum.FAILED.getMsg() + msg);
            responseHead.setOperationTime(System.currentTimeMillis() + "");
            return responseHead;
        }
    }
}