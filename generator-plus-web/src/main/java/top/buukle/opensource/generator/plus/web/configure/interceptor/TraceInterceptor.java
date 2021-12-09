package top.buukle.opensource.generator.plus.web.configure.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import top.buukle.opensource.generator.plus.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader("trace-id");
        MDC.put("trace", StringUtil.isEmpty(traceId) ? "!" + UUID.randomUUID().toString() : traceId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("trace");
    }
}
