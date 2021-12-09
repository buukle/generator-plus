package top.buukle.opensource.generator.plus.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.service.constants.SystemReturnEnum;
import top.buukle.opensource.generator.plus.service.exception.SystemException;
import top.buukle.opensource.generator.plus.utils.JsonUtil;
import top.buukle.opensource.generator.plus.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class InterfaceAspect {


    @Pointcut("execution(* top.buukle.opensource.generator.plus.controller.*(..))")
    public void webAspect() {}

    @Before("webAspect()")
    public void doBeforeWebAspect(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("接口:{} 接到请求,入参:{},ip:{} Method:{}", request.getRequestURI(), JsonUtil.toJSONString(joinPoint.getArgs()),request.getRemoteAddr(),request.getMethod());
        if(null != request){
            Object[] args = joinPoint.getArgs();
            if(args != null){
                for (Object obj : args) {
                    if(obj instanceof CommonRequest){
                        CommonRequest commonRequest = (CommonRequest) obj;
                        if(commonRequest != null){
                            if(commonRequest.getHead() == null){
                                throw new SystemException(SystemReturnEnum.FAILED_401_HEAD_NULL);
                            }
                            if(StringUtil.isEmpty(commonRequest.getHead().getAppId())){
                                throw new SystemException(SystemReturnEnum.FAILED_401_APP_ID_NULL);
                            }
                        }
                    }
                }
            }
        }
    }

    @Around("webAspect()")
    public Object doAroundWebAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        if(null != request){
            log.info("接口:{} 接到请求,响应:{},ip:{},Method:{},耗时:{}", request.getRequestURI(),JsonUtil.toJSONString(result),request.getRemoteAddr(),request.getMethod(),System.currentTimeMillis() - startTime);
        }
        return result;
    }
}
