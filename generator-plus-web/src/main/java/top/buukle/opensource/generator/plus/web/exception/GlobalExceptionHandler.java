package top.buukle.opensource.generator.plus.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.exception.CommonException;
import top.buukle.opensource.generator.plus.commons.log.BaseLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : springboot 应用全局异常解决方案
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static BaseLogger LOGGER = BaseLogger.getLogger(GlobalExceptionHandler.class);
    /**
     * 自定义异常处理
     * @param commonException
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public CommonResponse commonExceptionHandler(HttpServletRequest request, CommonException commonException, HttpServletResponse response) throws IOException {
        commonException.printStackTrace();
        LOGGER.error("Exception:",commonException);
        if(!"XMLHttpRequest".equals(request.getHeader("X-Requested-With")) && !request.getRequestURI().contains("/api/") && !request.getRequestURI().contains("/rpc/")){
//            this.writeNoticePage(response, BossClientConstants.NO_PERM_RETURN_HTML_TEMPLATE.replace("noPerm", commonException.getMsg()));
        }
        return new CommonResponse.Builder().buildFailedInner(commonException);
    }
    /**
     * @description 回写提示页面
     * @param response
     * @param html
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    private void writeNoticePage(HttpServletResponse response, String html) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.write(html);
        out.close();
    }

    /**
     * 系统异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandler(Exception exception) {
        exception.printStackTrace();
        LOGGER.error("Exception:",exception);
        return new CommonResponse.Builder().buildFailedWithOriginMsg(exception);
    }
}
