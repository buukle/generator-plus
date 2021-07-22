package top.buukle.generator.commons.call;


import top.buukle.generator.commons.call.head.ResponseHead;
import top.buukle.generator.commons.exception.CommonException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
public class CommonResponse<T> {
    /** 响应头*/
    private ResponseHead head;
    /** 响应体*/
    private T body;

    public CommonResponse (){

    }

    public CommonResponse(ResponseHead responseHead) {
        this.head = responseHead;
    }

    public CommonResponse(ResponseHead responseHead, T body) {
        this.head = responseHead;
        this.body = body;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static class Builder<T> {
        public CommonResponse buildSuccess(){
            return new CommonResponse(new ResponseHead.Builder().buildSuccess());
        }

        public CommonResponse buildSuccess(T body){

            return new CommonResponse(new ResponseHead.Builder().buildSuccess(), body);
        }

        public CommonResponse buildFailedInner(CommonException commonException) {
            return new CommonResponse(new ResponseHead.Builder().buildFailedInner(commonException));
        }

        public CommonResponse buildFailed(Exception exception) {
            return new CommonResponse(new ResponseHead.Builder().buildFailed("系统内部错误!"));
        }

        public CommonResponse buildFailedWithOriginMsg(Exception exception) {
            return new CommonResponse(new ResponseHead.Builder().buildFailed(exception));
        }

    }
}


