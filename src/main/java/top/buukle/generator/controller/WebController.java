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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
import top.buukle.generator.commons.log.BaseLogger;
import top.buukle.generator.entity.dto.*;
import top.buukle.generator.utils.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

        @RequestMapping("/auth/login")
        @ResponseBody
        public ANTDPCommonResponseDTO<ANTDPUserDTO>  authLogin(HttpServletRequest request,HttpServletResponse response ) {
                // 声明返回实体
                ANTDPCommonResponseDTO antdpCommonResponseDTO = new ANTDPCommonResponseDTO();
                // 声明初始化用户实体
                ANTDPUserDTO antdpUserDTO = new ANTDPUserDTO();

                antdpUserDTO.setUsername("admin");
                antdpUserDTO.setPassword("");
                antdpUserDTO.setAvatar("https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png");
                antdpUserDTO.setStatus("1");
                antdpUserDTO.setTelephone("");
                antdpUserDTO.setLastLoginIp("27.154.74.117");
                antdpUserDTO.setCreatorId("admin");
                antdpUserDTO.setRoleId("admin");
                antdpUserDTO.setLang("zh-CN");
                antdpUserDTO.setToken("4291d7da9005377ec9aec4a71ea837f");

                antdpCommonResponseDTO.setResult(antdpUserDTO);
                return antdpCommonResponseDTO;
        }

        @RequestMapping("/role")
        @ResponseBody
        public ANTDPCommonResponseDTO<ANTDPUserDTO> role(HttpServletRequest request,HttpServletResponse response ) {
                List<ANTDPRoleDTO> roleDTOList = new ArrayList<>();
                ANTDPRoleDTO role = this.getRole(request, response);
                roleDTOList.add(role);
                // 声明初始化返回实体
                ANTDPCommonResponseDTO antdpCommonResponseDTO = new ANTDPCommonResponseDTO();
                antdpCommonResponseDTO.setResult(roleDTOList);
                return antdpCommonResponseDTO;
        }

        private ANTDPRoleDTO getRole(HttpServletRequest request, HttpServletResponse response) {
                // 声明初始化角色实体
                ANTDPRoleDTO antdpRoleDTO = new ANTDPRoleDTO();

                antdpRoleDTO.setId("admin");
                antdpRoleDTO.setName("管理员");
                antdpRoleDTO.setDescribe("拥有所有权限");
                antdpRoleDTO.setStatus("1");
                antdpRoleDTO.setCreatorId("system");

                antdpRoleDTO.setCreateTime("1497160610259");
                antdpRoleDTO.setDeleted("0");

                // 声明初始化权限实体
                ArrayList<ANTDPPermissionDTO> antdpPermissionDTOArrayList = new ArrayList<>();
                ANTDPPermissionDTO antdpPermissionDTO = new ANTDPPermissionDTO();
                antdpPermissionDTO.setPermissionId("datasources");
                antdpPermissionDTO.setPermissionName("连接管理");
                antdpPermissionDTO.setRoleId("admin");

                // 声明初始化操作list
                ArrayList<ANTDPActionDTO> antdpActionDTOS = new ArrayList<>();
                Set <ANTDPActionDTO> antdpActionDTOSet = new HashSet<>();

                ANTDPActionDTO antdpActionDTO = new ANTDPActionDTO();
                antdpActionDTO.setAction("add");
                antdpActionDTO.setDefaultCheck(false);
                antdpActionDTO.setDescribe("新增");

                antdpActionDTOS.add(antdpActionDTO);
                antdpActionDTOSet.add(antdpActionDTO);

                ANTDPActionDTO antdpActionDTO1 = new ANTDPActionDTO();
                antdpActionDTO1.setAction("query");
                antdpActionDTO1.setDefaultCheck(false);
                antdpActionDTO1.setDescribe("查询");

                antdpActionDTOS.add(antdpActionDTO1);
                antdpActionDTOSet.add(antdpActionDTO1);

                ANTDPActionDTO antdpActionDTO2 = new ANTDPActionDTO();
                antdpActionDTO2.setAction("get");
                antdpActionDTO2.setDefaultCheck(false);
                antdpActionDTO2.setDescribe("详情");

                antdpActionDTOS.add(antdpActionDTO2);
                antdpActionDTOSet.add(antdpActionDTO2);

                ANTDPActionDTO antdpActionDTO3 = new ANTDPActionDTO();
                antdpActionDTO3.setAction("update");
                antdpActionDTO3.setDefaultCheck(false);
                antdpActionDTO3.setDescribe("修改");

                antdpActionDTOS.add(antdpActionDTO3);
                antdpActionDTOSet.add(antdpActionDTO3);

                ANTDPActionDTO antdpActionDTO4 = new ANTDPActionDTO();
                antdpActionDTO4.setAction("delete");
                antdpActionDTO4.setDefaultCheck(false);
                antdpActionDTO4.setDescribe("删除");

                antdpActionDTOS.add(antdpActionDTO4);
                antdpActionDTOSet.add(antdpActionDTO4);

                // 为 permission 设置 action
                antdpPermissionDTO.setActionList(antdpActionDTOS);
                antdpPermissionDTO.setActionEntitySet(antdpActionDTOSet);
                // 为 role 设置permission
                antdpPermissionDTOArrayList.add(antdpPermissionDTO);
                antdpRoleDTO.setPermissions(antdpPermissionDTOArrayList);
                return antdpRoleDTO;
        }

        @RequestMapping("/user/info")
        @ResponseBody
        public ANTDPCommonResponseDTO<ANTDPUserDTO> userInfo(HttpServletRequest request,HttpServletResponse response ) {

                // 声明初始化返回实体
                ANTDPCommonResponseDTO antdpCommonResponseDTO = new ANTDPCommonResponseDTO();

                // 声明初始化用户实体
                ANTDPUserDTO antdpUserDTO = new ANTDPUserDTO();

                antdpUserDTO.setId("4291d7da9005377ec9aec4a71ea837f");
                antdpUserDTO.setName("elvin");
                antdpUserDTO.setUsername("elvin");
                antdpUserDTO.setPassword("");
                antdpUserDTO.setAvatar("/avatar2.jpg");

                antdpUserDTO.setStatus("1");
                antdpUserDTO.setLastLoginIp("27.154.74.117");
                antdpUserDTO.setLastLoginTime("1534837621348");
                antdpUserDTO.setCreatorId("admin");
                antdpUserDTO.setCreateTime("1497160610259");

                antdpUserDTO.setMerchantCode("TLif2btpzg079h15bk");
                antdpUserDTO.setDeleted("0");
                antdpUserDTO.setRoleId("admin");

                // 为 user 设置角色
                antdpUserDTO.setRole(this.getRole( request, response ));
                // 为返回设置 result
                antdpCommonResponseDTO.setResult(antdpUserDTO);
                return antdpCommonResponseDTO;
        }

        @RequestMapping("/user/nav")
        @ResponseBody
        public ANTDPCommonResponseDTO<ANTDPNavigationDTO>  userNav(HttpServletRequest request,HttpServletResponse response ) {

                // 声明导航list
                List<ANTDPNavigationDTO> antdpNavigationDTOS = new ArrayList<>();

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTO = new ANTDPNavigationDTO();

                antdpNavigationDTO.setId(7);
                antdpNavigationDTO.setParentId(0);
                antdpNavigationDTO.setName("workplace");
                antdpNavigationDTO.setComponent("Workplace");

                MetaDTO metaDTO = new MetaDTO();
                metaDTO.setShow(true);
                metaDTO.setTitle("工作台");

                antdpNavigationDTO.setMeta(metaDTO);
                antdpNavigationDTOS.add(antdpNavigationDTO);

               /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTOForFrame = new ANTDPNavigationDTO();

                antdpNavigationDTOForFrame.setId(8);
                antdpNavigationDTOForFrame.setParentId(0);
                antdpNavigationDTOForFrame.setName("frame");
                antdpNavigationDTOForFrame.setRedirect("/workplace");
                antdpNavigationDTOForFrame.setComponent("PageView");

                MetaDTO metaDTOForFrame = new MetaDTO();
                metaDTOForFrame.setShow(true);
                metaDTOForFrame.setTitle("框架管理");

                antdpNavigationDTOForFrame.setMeta(metaDTOForFrame);
                antdpNavigationDTOS.add(antdpNavigationDTOForFrame);

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTOForFrameTemplates = new ANTDPNavigationDTO();

                antdpNavigationDTOForFrameTemplates.setId(9);
                antdpNavigationDTOForFrameTemplates.setParentId(8);
                antdpNavigationDTOForFrameTemplates.setName("/frame/templates/TemplatesList");
                antdpNavigationDTOForFrameTemplates.setPath("/frame/templates/templates-list/:pageNo([1-9]\\d*)?");
                antdpNavigationDTOForFrameTemplates.setComponent("frame/templates/TemplatesList");


                MetaDTO metaDTOForFrameTemplates = new MetaDTO();
                metaDTOForFrameTemplates.setShow(true);
                metaDTOForFrameTemplates.setTitle("框架模板");

                antdpNavigationDTOForFrameTemplates.setMeta(metaDTOForFrameTemplates);
                antdpNavigationDTOS.add(antdpNavigationDTOForFrameTemplates);

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTOForFrameTemplatesRule = new ANTDPNavigationDTO();

                antdpNavigationDTOForFrameTemplatesRule.setId(10);
                antdpNavigationDTOForFrameTemplatesRule.setParentId(8);
                antdpNavigationDTOForFrameTemplatesRule.setName("/frame/templatesRule/TemplatesRuleList");
                antdpNavigationDTOForFrameTemplatesRule.setPath("/frame/templates-rule/templates-rule-list/:pageNo([1-9]\\d*)?");
                antdpNavigationDTOForFrameTemplatesRule.setComponent("frame/templatesRule/TemplatesRuleList");

                MetaDTO metaDTOForFrameTemplatesRule = new MetaDTO();
                metaDTOForFrameTemplatesRule.setShow(true);
                metaDTOForFrameTemplatesRule.setTitle("模板规则");

                antdpNavigationDTOForFrameTemplatesRule.setMeta(metaDTOForFrameTemplatesRule);
                antdpNavigationDTOS.add(antdpNavigationDTOForFrameTemplatesRule);


                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTOForGen = new ANTDPNavigationDTO();

                antdpNavigationDTOForGen.setId(11);
                antdpNavigationDTOForGen.setParentId(0);
                antdpNavigationDTOForGen.setName("gen");
                antdpNavigationDTOForGen.setRedirect("/workplace");
                antdpNavigationDTOForGen.setComponent("PageView");

                MetaDTO metaDTOForGen = new MetaDTO();
                metaDTOForGen.setShow(true);
                metaDTOForGen.setTitle("逆向管理");

                antdpNavigationDTOForGen.setMeta(metaDTOForGen);
                antdpNavigationDTOS.add(antdpNavigationDTOForGen);

                /*----------------------------------------------------------------*/

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTO1 = new ANTDPNavigationDTO();

                antdpNavigationDTO1.setId(10011);
                antdpNavigationDTO1.setParentId(11);
                antdpNavigationDTO1.setName("/gen/datasources/DatasourcesList");
                antdpNavigationDTO1.setPath("/gen/datasources/datasources-list/:pageNo([1-9]\\d*)?");
                antdpNavigationDTO1.setComponent("gen/datasources/DatasourcesList");

                MetaDTO metaDTO1 = new MetaDTO();
                metaDTO1.setShow(true);
                metaDTO1.setTitle("连接管理");

                antdpNavigationDTO1.setMeta(metaDTO1);
                antdpNavigationDTOS.add(antdpNavigationDTO1);

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTO2 = new ANTDPNavigationDTO();

                antdpNavigationDTO2.setId(10012);
                antdpNavigationDTO2.setParentId(11);
                antdpNavigationDTO2.setName("/gen/templates/TemplatesList");
                antdpNavigationDTO2.setPath("/gen/templates/templates-list/:pageNo([1-9]\\d*)?");
                antdpNavigationDTO2.setComponent("gen/templates/TemplatesList");

                MetaDTO metaDTO2 = new MetaDTO();
                metaDTO2.setShow(true);
                metaDTO2.setTitle("代码模板");

                antdpNavigationDTO2.setMeta(metaDTO2);
                antdpNavigationDTOS.add(antdpNavigationDTO2);

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTO3 = new ANTDPNavigationDTO();

                antdpNavigationDTO3.setId(10013);
                antdpNavigationDTO3.setParentId(11);
                antdpNavigationDTO3.setName("/gen/configures/ConfiguresList");
                antdpNavigationDTO3.setPath("/gen/configures/configures-list/:pageNo([1-9]\\d*)?");
                antdpNavigationDTO3.setComponent("gen/configures/ConfiguresList");

                MetaDTO metaDTO3 = new MetaDTO();
                metaDTO3.setShow(true);
                metaDTO3.setTitle("配置管理");

                antdpNavigationDTO3.setMeta(metaDTO3);
                antdpNavigationDTOS.add(antdpNavigationDTO3);

                /*----------------------------------------------------------------*/
                ANTDPNavigationDTO antdpNavigationDTO4 = new ANTDPNavigationDTO();

                antdpNavigationDTO4.setId(10014);
                antdpNavigationDTO4.setParentId(11);
                antdpNavigationDTO4.setName("/gen/configuresExecute/ConfiguresExecuteList");
                antdpNavigationDTO4.setPath("/gen/configures-execute/configures-execute-list/:pageNo([1-9]\\d*)?");
                antdpNavigationDTO4.setComponent("gen/configuresExecute/ConfiguresExecuteList");

                MetaDTO metaDTO4 = new MetaDTO();
                metaDTO4.setShow(true);
                metaDTO4.setTitle("日志管理");

                antdpNavigationDTO4.setMeta(metaDTO4);
                antdpNavigationDTOS.add(antdpNavigationDTO4);

                // 组织返回
                ANTDPCommonResponseDTO antdpCommonResponseDTO = new ANTDPCommonResponseDTO();
                antdpCommonResponseDTO.setResult(antdpNavigationDTOS);
                return antdpCommonResponseDTO;
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
