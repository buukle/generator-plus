/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName:
 * Author:   elvin
 * Date:     2019/8/15 1:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import top.buukle.generator.commons.log.BaseLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 〈〉
 * @author elvin
 * @create 2019/8/15
 * @since 1.0.0
 */
@Controller
@ApiIgnore
public class WebController {

    private static BaseLogger LOGGER = BaseLogger.getLogger(WebController.class);

    @Autowired
    private Environment env;

    /**
     * security 登录页面控制器
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/login.html")
    public ModelAndView toLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * security 主页面控制器
     * @param modelAndView
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    /**
     *  欢迎页
     * @return
     */
    @RequestMapping("/index/welcome")
    public ModelAndView indexWelcome(HttpServletRequest request,HttpServletResponse response ,  ModelAndView modelAndView) {
        modelAndView.setViewName("index/welcome");
        return modelAndView;
    }
    /**
     * 401页面
     */
    @GetMapping(value = "/error/401")
    public ModelAndView error_401(ModelAndView modelAndView) {
        modelAndView.setViewName("401");
        return modelAndView;
    }

    /**
     * 404页面
     */
    @GetMapping(value = "/error/404")
    public ModelAndView error_404(ModelAndView modelAndView) {
        modelAndView.setViewName("404");
        return modelAndView;
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/error/500")
    public ModelAndView error_500(ModelAndView modelAndView) {
        modelAndView.setViewName("500");
        return modelAndView;
    }
    /**
     * 500页面
     */
    @GetMapping(value = "/error/503")
    public ModelAndView error_503(ModelAndView modelAndView) {
        modelAndView.setViewName("503");
        return modelAndView;
    }
}
