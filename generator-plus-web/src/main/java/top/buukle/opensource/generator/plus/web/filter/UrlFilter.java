package top.buukle.opensource.generator.plus.web.filter;

import top.buukle.opensource.generator.plus.service.constants.SystemConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponseWrapper httpResponse = new HttpServletResponseWrapper((HttpServletResponse) response);
        System.out.println(httpRequest.getRequestURI());
        String path=httpRequest.getRequestURI();
        path = path.replace("//","/");
        if(path.startsWith(SystemConstants.SOFT_CONTEXT_PATH)){
            String replace = path.replace(SystemConstants.SOFT_CONTEXT_PATH, "/");
            replace = replace.replace("//","/");
            httpRequest.getRequestDispatcher(replace).forward(request,response);
        }
       else {
            chain.doFilter(request,response);
        }
        return;
    }
}