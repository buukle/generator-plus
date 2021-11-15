package top.buukle.opensource.generator.plus.utils.exception;



/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 */
public class UtilException extends RuntimeException {

    /** 状态码*/
    private String status;
    /** 响应码*/
    private String code;
    /** 信息*/
    private String msg;

    public UtilException() {

    }
    public UtilException(String status, String code, String msg) {
        super(msg);
        this.status = status;
        this.code = code;
        this.msg = msg;
    }
    public UtilException(UtilReturnEnum returnEnum) {
        this.status = returnEnum.getStatus();
        this.code = returnEnum.getCode();
        this.msg = returnEnum.getMsg();
    }
    public UtilException(UtilReturnEnum returnEnum,String msg) {
        this.status = returnEnum.getStatus();
        this.code = returnEnum.getCode();
        this.msg = returnEnum.getMsg() + msg;
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
