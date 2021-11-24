package top.buukle.opensource.generator.plus.commons.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
public class BaseLogger {

    public Logger logger;

    private BaseLogger(Logger logger) {
        super();
        this.logger = logger;
    }

    /**
     * 获取ElogLogger
     * @param clazz
     * @return
     */
    public static BaseLogger getLogger(Class<?> clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        return new BaseLogger(logger);
    }

    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public String getTraceIdStr(String msg) {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<stacks.length;i++){
            if(logger.getName().equals(stacks[i].getClassName())){
                sb.append(stacks[i].getClassName());
                sb.append( "." );
                sb.append(stacks[i].getMethodName());
                sb.append("(");
                sb.append(stacks[i].getFileName());
                sb.append(":");
                sb.append(stacks[i].getLineNumber());
                sb.append(")");
                break;
            }
        }
        sb.append("[traceId:");
        sb.append(getTraceId());
        sb.append("] ");
        sb.append(msg);
        return sb.toString();
    }

    private String getTraceId() {
        String traceId="-1";
        try {
            ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
            if(servletRequestAttributes!=null){
                HttpServletRequest request = servletRequestAttributes.getRequest();
                traceId = request.getHeader("trace-id");
            }
        } catch (Exception e) {

        }
        return traceId;
    }

    public void debug(String msg,Object... args){
        logger.debug(getTraceIdStr(msg),args);
    }

    /**
     * 位置0：sid
     * "位置1：{}位置2：{}","a","b"
     * @param msg
     * @param args
     */
    public void info(String msg,Object... args){
        logger.info(getTraceIdStr(msg),args);
    }

    public void warn(String msg,Object... args){
        logger.warn(getTraceIdStr(msg),args);
    }

    public void error(String msg,Object... args){
        logger.error(getTraceIdStr(msg),args);
    }

    /**
     * 异常日志
     * @param msg
     * @param t
     */
    public void error(String msg,Throwable t){
        logger.error(getTraceIdStr(msg),t);
    }
}
