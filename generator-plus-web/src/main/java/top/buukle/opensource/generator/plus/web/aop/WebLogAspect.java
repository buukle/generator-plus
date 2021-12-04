package top.buukle.opensource.generator.plus.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.buukle.opensource.generator.plus.commons.log.BaseLogger;
import top.buukle.opensource.generator.plus.utils.JsonUtil;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {

    private final static BaseLogger LOGGER = BaseLogger.getLogger(WebLogAspect.class);

    @Pointcut("execution(* top.buukle.opensource.generator.plus.controller.*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if(null != request){
            LOGGER.info("接口:{},接到请求,入参:{},ip:{} Method:{}", request.getRequestURL().toString(), JsonUtil.toJSONString(joinPoint.getArgs()),request.getRemoteAddr(),request.getMethod());
        }
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        if(null != request){
            LOGGER.info("接口:{},接到请求,响应:{},ip:{},Method:{},耗时:{}", request.getRequestURL().toString(),JsonUtil.toJSONString(result),request.getRemoteAddr(),request.getMethod(),System.currentTimeMillis() - startTime);
        }
        return result;
    }
}
