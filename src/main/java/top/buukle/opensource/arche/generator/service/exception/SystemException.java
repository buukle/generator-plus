package top.buukle.opensource.arche.generator.service.exception;

import top.buukle.opensource.arche.generator.commons.exception.CommonException;
import top.buukle.opensource.arche.generator.service.constants.SystemReturnEnum;

/**
 * @description
 * @Author jingkang
 * @Date 2020/12/1
 */
public class SystemException extends CommonException{

    public SystemException(String status, String code, String msg) {
        super(status, code, msg);
    }

    public SystemException(SystemReturnEnum securityReturnEnum) {
        super(securityReturnEnum.getStatus(), securityReturnEnum.getCode(), securityReturnEnum.getMsg());
    }

    public SystemException(SystemReturnEnum securityReturnEnum, String msg) {
        super(securityReturnEnum.getStatus(), securityReturnEnum.getCode(), securityReturnEnum.getMsg() + msg);
    }

    public static CommonException convert(SystemException s ,CommonException c){
        c.setCode(s.getCode());
        c.setStatus(s.getStatus());
        c.setMsg(s.getMsg());
        return c;
    }
}
