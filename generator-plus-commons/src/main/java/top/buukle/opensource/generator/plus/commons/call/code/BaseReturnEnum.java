package top.buukle.opensource.generator.plus.commons.call.code;


import top.buukle.opensource.generator.plus.commons.status.StatusConstants;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/7/26.
 * @Description :
 */
public enum BaseReturnEnum {

    SUCCESS(StatusConstants.SUCCESS,"000000","成功!"),
    FAILED(StatusConstants.FAILED,"999999","失败!"),

    STATUS_MACHINE_PARAM_NULL(StatusConstants.FAILED,"999998","状态机参数错误!"),
    STATUS_MACHINE_TARGET_MULTI(StatusConstants.FAILED,"999997","状态机异常,流转状态不唯一!"),
    STATUS_MACHINE_TARGET_NULL(StatusConstants.FAILED,"999996","状态机异常,没有流转状态集!"),
    STATUS_MACHINE_STATUS_ILLEGAL(StatusConstants.FAILED,"999995","状态机异常,主状态值非法"),
    STATUS_MACHINE_AUDIT_STATUS_ILLEGAL(StatusConstants.FAILED,"999994","状态机异常,审核状态值非法"),

    ;
    private String status;
    private String code;
    private String msg;

    BaseReturnEnum(String status, String code, String msg) {
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
