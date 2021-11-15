package top.buukle.opensource.generator.plus.utils.exception;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/7/26.
 * @Description :
 */
public enum UtilReturnEnum {

    SUCCESS("S","000000","成功!"),
    FAILED("F","999999","失败!"),

    /*--util 内部返回码 {BC_INNER**}*/
    BC_INNER_UTIL_CONCURRENCY("F", "BC_INNER_UTIL_CONCURRENCY","操作异常,不允许同时操作!"),
    ;
    private String status;
    private String code;
    private String msg;

    UtilReturnEnum(String status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
