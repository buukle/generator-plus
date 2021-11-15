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
package top.buukle.opensource.generator.plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPCommonResponseVO;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPNavigationVO;
import top.buukle.opensource.generator.plus.service.vo.antd.ANTDPUserVO;
import top.buukle.opensource.generator.plus.service.vo.antd.MetaVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 〈〉
 * @author elvin
 * @create 2019/8/15
 * @since 1.0.0
 */
@Controller
@ApiIgnore
public class WebController {

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
                antdpNavigationVO.setComponent("workplace");

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
                metaVOForFrame.setTitle("原型管理");
                metaVOForFrame.setIcon("build");

                antdpNavigationVOForFrame.setMeta(metaVOForFrame);
                antdpNavigationVOS.add(antdpNavigationVOForFrame);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVOForFrameArchetypes = new ANTDPNavigationVO();

                antdpNavigationVOForFrameArchetypes.setId(9);
                antdpNavigationVOForFrameArchetypes.setParentId(8);
                antdpNavigationVOForFrameArchetypes.setName("/frame/archetypes/list");
                antdpNavigationVOForFrameArchetypes.setPath("/frame/archetypes/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVOForFrameArchetypes.setComponent("frame/archetypes/list");


                MetaVO metaVOForFrameArchetypes = new MetaVO();
                metaVOForFrameArchetypes.setShow(true);
                metaVOForFrameArchetypes.setTitle("archetypes(java)");
                metaVOForFrameArchetypes.setIcon("snippets");

                antdpNavigationVOForFrameArchetypes.setMeta(metaVOForFrameArchetypes);
                antdpNavigationVOS.add(antdpNavigationVOForFrameArchetypes);
                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVOForFrameArchetypeExecutes = new ANTDPNavigationVO();

                antdpNavigationVOForFrameArchetypeExecutes.setId(10);
                antdpNavigationVOForFrameArchetypeExecutes.setParentId(8);
                antdpNavigationVOForFrameArchetypeExecutes.setName("/frame/archetypesExecute/list");
                antdpNavigationVOForFrameArchetypeExecutes.setPath("/frame/archetypes-execute/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVOForFrameArchetypeExecutes.setComponent("frame/archetypesExecute/list");


                MetaVO metaVOForFrameArchetypeExecutes = new MetaVO();
                metaVOForFrameArchetypeExecutes.setShow(true);
                metaVOForFrameArchetypeExecutes.setTitle("原型日志");
                metaVOForFrameArchetypeExecutes.setIcon("switcher");

                antdpNavigationVOForFrameArchetypeExecutes.setMeta(metaVOForFrameArchetypeExecutes);
                antdpNavigationVOS.add(antdpNavigationVOForFrameArchetypeExecutes);

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
                antdpNavigationVO1.setName("/gen/datasources/list");
                antdpNavigationVO1.setPath("/gen/datasources/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO1.setComponent("gen/datasources/list");

                MetaVO metaVO1 = new MetaVO();
                metaVO1.setShow(true);
                metaVO1.setTitle("连接管理");
                metaVO1.setIcon("database");

                antdpNavigationVO1.setMeta(metaVO1);
                antdpNavigationVOS.add(antdpNavigationVO1);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO5 = new ANTDPNavigationVO();

                antdpNavigationVO5.setId(100111);
                antdpNavigationVO5.setParentId(11);
                antdpNavigationVO5.setName("/gen/templatesGroup/list");
                antdpNavigationVO5.setPath("/gen/templates-group/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO5.setComponent("gen/templatesGroup/list");

                MetaVO metaVO5 = new MetaVO();
                metaVO5.setShow(true);
                metaVO5.setTitle("模板分组");
                metaVO5.setIcon("code");

                antdpNavigationVO5.setMeta(metaVO5);
                antdpNavigationVOS.add(antdpNavigationVO5);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO2 = new ANTDPNavigationVO();

                antdpNavigationVO2.setId(10012);
                antdpNavigationVO2.setParentId(11);
                antdpNavigationVO2.setName("/gen/templates/list");
                antdpNavigationVO2.setPath("/gen/templates/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO2.setComponent("gen/templates/list");

                MetaVO metaVO2 = new MetaVO();
                metaVO2.setShow(true);
                metaVO2.setTitle("模板管理");
                metaVO2.setIcon("code");

                antdpNavigationVO2.setMeta(metaVO2);
                antdpNavigationVOS.add(antdpNavigationVO2);

                /*----------------------------------------------------------------*/
                ANTDPNavigationVO antdpNavigationVO3 = new ANTDPNavigationVO();

                antdpNavigationVO3.setId(10013);
                antdpNavigationVO3.setParentId(11);
                antdpNavigationVO3.setName("/gen/configures/list");
                antdpNavigationVO3.setPath("/gen/configures/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO3.setComponent("gen/configures/list");

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
                antdpNavigationVO4.setName("/gen/configuresExecute/list");
                antdpNavigationVO4.setPath("/gen/configures-execute/list/:pageNo([1-9]\\d*)?");
                antdpNavigationVO4.setComponent("gen/configuresExecute/list");

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
