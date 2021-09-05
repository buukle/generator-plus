# buukle-generator

#### 演示地址 
[buukle-generator](http://generator.buukle.top/opensource-arche-generator/index.html#/workplace)
 
测试账号 : admin / admin

#### 介绍

布壳儿脚手架服务,可自由灵活配置多数据源,自定义模板,并根据模板生成前后端代码,支持一键导入本地项目结构中.

#### 环境

java1.8

#### 软件架构

backend : springboot 2.2.0.RELEASE + mybatis + mysql5.7以上 + beetl + mybatis-plus-generator

frontend :  Antd ( ant-design-vue-pro) 

#### 使用教程

0. 环境 jre 
1. 到 https://gitee.com/buukle/buukle-generator/releases 版本列表根据特性挑选喜欢的版本,下载压缩包(zip,tar.gz),解压为jar包 
2. 启动 : nohup java -jar buukle-generator-1.0.0-RELEASE.jar >> /opt/logs/buukle-generator/generator.log 2>&1 &
3. 访问 : http://{ip}:{port}/buukle-generator/index.html

#### 源码开发

1. git clone https://gitee.com/buukle/buukle-generator.git
2. 更改本地maven settings 为 本项目根路径下的 settings.xml
3. mvn clean
4. mvn install
5. 执行主类 GeneratorApplication main 方法即可成功运行,启动完成后, **访问 http://127.0.0.1/opensource-arche-generator/index.html 即可进入主界面** 
6. 表模型中预留了用户,租户等字段,开源版本未接入用户中心,认证中心,权限体系和应用体系,使用固定静态账号密码 (测试账号 : admin / admin)登录,如有需要,可根据源码进行企业内部认证源体系对接
7. 如果想本地化数据源,请连接代码中的数据库,导出数据表信息到本地库,并修改application-dev.yaml application-dev.yaml 下的数据源信息为你本地库,或者公司库地址
8. **如果想使用本地settings,请下载 buukle-parent,buukle-common库, mvn clean install deploy 将jar发布到本地maven仓库**

#### 使用说明

0.  工作台

![工作台](https://images.gitee.com/uploads/images/2021/0729/164208_2e90ee51_1694096.png "屏幕截图.png")

1.  新建连接

![新建并测试连接](https://images.gitee.com/uploads/images/2021/0729/164312_7dfa8a0d_1694096.png "屏幕截图.png")
    
2.  新建模板

![新建模板](https://images.gitee.com/uploads/images/2021/0729/164342_da1af906_1694096.png "屏幕截图.png")
    
3.  新建配置

在配置记录中,选择需要生成的连接,表清单,以及需要生成的模板清单,按照提示进行配置包名等表单项
    
![新建配置](https://images.gitee.com/uploads/images/2021/0729/164409_c4f71d01_1694096.png "屏幕截图.png")

4.  生成代码

点击生成,会按照配置记录中的信息进行生成代码,并打成压缩包,根据配置的一键导入脚本生成.bat文件,也会打进压缩包中
    
![生成代码](https://images.gitee.com/uploads/images/2021/0729/164440_3ba9a8b3_1694096.png "屏幕截图.png")

5.  下载代码

![下载代码](https://images.gitee.com/uploads/images/2021/0729/164455_e7aa2d1e_1694096.png "屏幕截图.png")

6.  一键导入

将下载下来的zip源码压缩包解压,双击执行copy.bat脚本,将代码一键导入本地项目下 (暂时只支持windows版本的脚本,mac可以自行修改该脚本内容及文件后缀名)
    
![一键导入本地项目](https://images.gitee.com/uploads/images/2021/0729/164546_87e99883_1694096.png "屏幕截图.png")

#### 参与贡献

1.  Fork 本仓库
2.  新建分支
3.  提交代码
4.  新建 Pull Request

