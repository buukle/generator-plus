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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import top.buukle.generator.commons.log.BaseLogger;
import top.buukle.generator.entity.vo.antd.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        @RequestMapping("/auth/login")
        @ResponseBody
        public ANTDPCommonResponseVO<ANTDPUserVO> authLogin(HttpServletRequest request, HttpServletResponse response ) {
                // 声明返回实体
                ANTDPCommonResponseVO antdpCommonResponseVO = new ANTDPCommonResponseVO();
                // 声明初始化用户实体
                ANTDPUserVO antdpUserVO = new ANTDPUserVO();

                antdpUserVO.setUsername("admin");
                antdpUserVO.setPassword("");
                antdpUserVO.setAvatar("");
                antdpUserVO.setStatus("1");
                antdpUserVO.setTelephone("");
                antdpUserVO.setLastLoginIp("27.154.74.117");
                antdpUserVO.setCreatorId("admin");
                antdpUserVO.setRoleId("admin");
                antdpUserVO.setLang("zh-CN");
                antdpUserVO.setToken("4291d7da9005377ec9aec4a71ea837f");

                antdpCommonResponseVO.setResult(antdpUserVO);
                return antdpCommonResponseVO;
        }

        @RequestMapping("/role")
        @ResponseBody
        public ANTDPCommonResponseVO<ANTDPUserVO> role(HttpServletRequest request, HttpServletResponse response ) {
                List<ANTDPRoleVO> roleDTOList = new ArrayList<>();
                ANTDPRoleVO role = this.getRole(request, response);
                roleDTOList.add(role);
                // 声明初始化返回实体
                ANTDPCommonResponseVO antdpCommonResponseVO = new ANTDPCommonResponseVO();
                antdpCommonResponseVO.setResult(roleDTOList);
                return antdpCommonResponseVO;
        }

        private ANTDPRoleVO getRole(HttpServletRequest request, HttpServletResponse response) {
                // 声明初始化角色实体
                ANTDPRoleVO antdpRoleVO = new ANTDPRoleVO();

                antdpRoleVO.setId("admin");
                antdpRoleVO.setName("管理员");
                antdpRoleVO.setDescribe("拥有所有权限");
                antdpRoleVO.setStatus("1");
                antdpRoleVO.setCreatorId("system");

                antdpRoleVO.setCreateTime("1497160610259");
                antdpRoleVO.setDeleted("0");

                // 声明初始化权限实体
                ArrayList<ANTDPPermissionVO> antdpPermissionVOArrayList = new ArrayList<>();
                ANTDPPermissionVO antdpPermissionVO = new ANTDPPermissionVO();
                antdpPermissionVO.setPermissionId("datasources");
                antdpPermissionVO.setPermissionName("连接管理");
                antdpPermissionVO.setRoleId("admin");

                // 声明初始化操作list
                ArrayList<ANTDPActionVO> antdpActionVOS = new ArrayList<>();
                Set <ANTDPActionVO> antdpActionVOSet = new HashSet<>();

                ANTDPActionVO antdpActionVO = new ANTDPActionVO();
                antdpActionVO.setAction("add");
                antdpActionVO.setDefaultCheck(false);
                antdpActionVO.setDescribe("新增");

                antdpActionVOS.add(antdpActionVO);
                antdpActionVOSet.add(antdpActionVO);

                ANTDPActionVO antdpActionVO1 = new ANTDPActionVO();
                antdpActionVO1.setAction("query");
                antdpActionVO1.setDefaultCheck(false);
                antdpActionVO1.setDescribe("查询");

                antdpActionVOS.add(antdpActionVO1);
                antdpActionVOSet.add(antdpActionVO1);

                ANTDPActionVO antdpActionVO2 = new ANTDPActionVO();
                antdpActionVO2.setAction("get");
                antdpActionVO2.setDefaultCheck(false);
                antdpActionVO2.setDescribe("详情");

                antdpActionVOS.add(antdpActionVO2);
                antdpActionVOSet.add(antdpActionVO2);

                ANTDPActionVO antdpActionVO3 = new ANTDPActionVO();
                antdpActionVO3.setAction("update");
                antdpActionVO3.setDefaultCheck(false);
                antdpActionVO3.setDescribe("修改");

                antdpActionVOS.add(antdpActionVO3);
                antdpActionVOSet.add(antdpActionVO3);

                ANTDPActionVO antdpActionVO4 = new ANTDPActionVO();
                antdpActionVO4.setAction("delete");
                antdpActionVO4.setDefaultCheck(false);
                antdpActionVO4.setDescribe("删除");

                antdpActionVOS.add(antdpActionVO4);
                antdpActionVOSet.add(antdpActionVO4);

                // 为 permission 设置 action
                antdpPermissionVO.setActionList(antdpActionVOS);
                antdpPermissionVO.setActionEntitySet(antdpActionVOSet);
                // 为 role 设置permission
                antdpPermissionVOArrayList.add(antdpPermissionVO);
                antdpRoleVO.setPermissions(antdpPermissionVOArrayList);
                return antdpRoleVO;
        }

        @RequestMapping("/user/info")
        @ResponseBody
        public ANTDPCommonResponseVO<ANTDPUserVO> userInfo(HttpServletRequest request, HttpServletResponse response ) {

                // 声明初始化返回实体
                ANTDPCommonResponseVO antdpCommonResponseVO = new ANTDPCommonResponseVO();

                // 声明初始化用户实体
                ANTDPUserVO antdpUserVO = new ANTDPUserVO();

                antdpUserVO.setId("4291d7da9005377ec9aec4a71ea837f");
                antdpUserVO.setName("elvin");
                antdpUserVO.setUsername("elvin");
                antdpUserVO.setPassword("");
                antdpUserVO.setAvatar("/avatar2.jpg");

                antdpUserVO.setStatus("1");
                antdpUserVO.setLastLoginIp("27.154.74.117");
                antdpUserVO.setLastLoginTime("1534837621348");
                antdpUserVO.setCreatorId("admin");
                antdpUserVO.setCreateTime("1497160610259");

                antdpUserVO.setMerchantCode("TLif2btpzg079h15bk");
                antdpUserVO.setDeleted("0");
                antdpUserVO.setRoleId("admin");

                // 为 user 设置角色
                antdpUserVO.setRole(this.getRole( request, response ));
                // 为返回设置 result
                antdpCommonResponseVO.setResult(antdpUserVO);
                return antdpCommonResponseVO;
        }

        @RequestMapping("/user/nav")
        @ResponseBody
        public ANTDPCommonResponseVO<ANTDPNavigationVO> userNav(HttpServletRequest request, HttpServletResponse response ) {

                // 声明导航list
                List<ANTDPNavigationVO> antdpNavigationVOS = new ArrayList<>();

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO = new ANTDPNavigationVO();

                antdpNavigationVO.setId(7);
                antdpNavigationVO.setParentId(0);
                antdpNavigationVO.setName("workplace");
                antdpNavigationVO.setComponent("Workplace");

                MetaVO metaVO = new MetaVO();
                metaVO.setShow(true);
                metaVO.setTitle("工作台");
                metaVO.setIcon("dashboard");


                antdpNavigationVO.setMeta(metaVO);
                antdpNavigationVOS.add(antdpNavigationVO);

               /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVOForFrame = new ANTDPNavigationVO();

                antdpNavigationVOForFrame.setId(8);
                antdpNavigationVOForFrame.setParentId(0);
                antdpNavigationVOForFrame.setName("frame");
                antdpNavigationVOForFrame.setRedirect("/workplace");
                antdpNavigationVOForFrame.setComponent("PageView");

                MetaVO metaVOForFrame = new MetaVO();
                metaVOForFrame.setShow(true);
                metaVOForFrame.setTitle("框架管理");
                metaVOForFrame.setIcon("build");

                antdpNavigationVOForFrame.setMeta(metaVOForFrame);
                antdpNavigationVOS.add(antdpNavigationVOForFrame);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVOForFrameTemplates = new ANTDPNavigationVO();

                antdpNavigationVOForFrameTemplates.setId(9);
                antdpNavigationVOForFrameTemplates.setParentId(8);
                antdpNavigationVOForFrameTemplates.setName("/frame/templates/TemplatesList");
                antdpNavigationVOForFrameTemplates.setPath("/frame/templates/templates-list/:pageNo([1-9]\\d*)?");
                antdpNavigationVOForFrameTemplates.setComponent("frame/templates/TemplatesList");


                MetaVO metaVOForFrameTemplates = new MetaVO();
                metaVOForFrameTemplates.setShow(true);
                metaVOForFrameTemplates.setTitle("框架模板");
                metaVOForFrameTemplates.setIcon("snippets");

                antdpNavigationVOForFrameTemplates.setMeta(metaVOForFrameTemplates);
                antdpNavigationVOS.add(antdpNavigationVOForFrameTemplates);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVOForFrameTemplatesRule = new ANTDPNavigationVO();

                antdpNavigationVOForFrameTemplatesRule.setId(10);
                antdpNavigationVOForFrameTemplatesRule.setParentId(8);
                antdpNavigationVOForFrameTemplatesRule.setName("/frame/templatesRule/TemplatesRuleList");
                antdpNavigationVOForFrameTemplatesRule.setPath("/frame/templates-rule/templates-rule-list/:pageNo([1-9]\\d*)?");
                antdpNavigationVOForFrameTemplatesRule.setComponent("frame/templatesRule/TemplatesRuleList");

                MetaVO metaVOForFrameTemplatesRule = new MetaVO();
                metaVOForFrameTemplatesRule.setShow(true);
                metaVOForFrameTemplatesRule.setTitle("模板规则");
                metaVOForFrameTemplatesRule.setIcon("control");

                antdpNavigationVOForFrameTemplatesRule.setMeta(metaVOForFrameTemplatesRule);
                antdpNavigationVOS.add(antdpNavigationVOForFrameTemplatesRule);


                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVOForGen = new ANTDPNavigationVO();

                antdpNavigationVOForGen.setId(11);
                antdpNavigationVOForGen.setParentId(0);
                antdpNavigationVOForGen.setName("gen");
                antdpNavigationVOForGen.setRedirect("/workplace");
                antdpNavigationVOForGen.setComponent("PageView");

                MetaVO metaVOForGen = new MetaVO();
                metaVOForGen.setShow(true);
                metaVOForGen.setTitle("逆向管理");
                metaVOForGen.setIcon("interaction");

                antdpNavigationVOForGen.setMeta(metaVOForGen);
                antdpNavigationVOS.add(antdpNavigationVOForGen);

                /*----------------------------------------------------------------*/

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO1 = new ANTDPNavigationVO();

                antdpNavigationVO1.setId(10011);
                antdpNavigationVO1.setParentId(11);
                antdpNavigationVO1.setName("/gen/datasources/DatasourcesList");
                antdpNavigationVO1.setPath("/gen/datasources/datasources-list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO1.setComponent("gen/datasources/DatasourcesList");

                MetaVO metaVO1 = new MetaVO();
                metaVO1.setShow(true);
                metaVO1.setTitle("连接管理");
                metaVO1.setIcon("database");

                antdpNavigationVO1.setMeta(metaVO1);
                antdpNavigationVOS.add(antdpNavigationVO1);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO2 = new ANTDPNavigationVO();

                antdpNavigationVO2.setId(10012);
                antdpNavigationVO2.setParentId(11);
                antdpNavigationVO2.setName("/gen/templates/TemplatesList");
                antdpNavigationVO2.setPath("/gen/templates/templates-list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO2.setComponent("gen/templates/TemplatesList");

                MetaVO metaVO2 = new MetaVO();
                metaVO2.setShow(true);
                metaVO2.setTitle("代码模板");
                metaVO2.setIcon("code");

                antdpNavigationVO2.setMeta(metaVO2);
                antdpNavigationVOS.add(antdpNavigationVO2);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO3 = new ANTDPNavigationVO();

                antdpNavigationVO3.setId(10013);
                antdpNavigationVO3.setParentId(11);
                antdpNavigationVO3.setName("/gen/configures/ConfiguresList");
                antdpNavigationVO3.setPath("/gen/configures/configures-list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO3.setComponent("gen/configures/ConfiguresList");

                MetaVO metaVO3 = new MetaVO();
                metaVO3.setShow(true);
                metaVO3.setTitle("配置管理");
                metaVO3.setIcon("setting");

                antdpNavigationVO3.setMeta(metaVO3);
                antdpNavigationVOS.add(antdpNavigationVO3);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO4 = new ANTDPNavigationVO();

                antdpNavigationVO4.setId(10014);
                antdpNavigationVO4.setParentId(11);
                antdpNavigationVO4.setName("/gen/configuresExecute/ConfiguresExecuteList");
                antdpNavigationVO4.setPath("/gen/configures-execute/configures-execute-list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO4.setComponent("gen/configuresExecute/ConfiguresExecuteList");

                MetaVO metaVO4 = new MetaVO();
                metaVO4.setShow(true);
                metaVO4.setTitle("日志管理");
                metaVO4.setIcon("switcher");

                antdpNavigationVO4.setMeta(metaVO4);
                antdpNavigationVOS.add(antdpNavigationVO4);

                // 组织返回
                ANTDPCommonResponseVO antdpCommonResponseVO = new ANTDPCommonResponseVO();
                antdpCommonResponseVO.setResult(antdpNavigationVOS);
                return antdpCommonResponseVO;
        }
}
