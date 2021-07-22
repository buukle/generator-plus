# buukle-generator

#### 介绍

布壳儿脚手架服务,可自由灵活配置多数据源,自定义模板,并根据模板生成前后端代码,支持一键导入本地项目结构中.

#### 环境

java1.8

#### 软件架构

backend : springboot 2.2.0.RELEASE + mybatis + mysql5.7以上 + beetl + mybatis-plus-generator

frontend :  thymeleaf + layui + js + jquery

#### 安装教程

1.  git clone https://gitee.com/buukle/buukle-generator.git
2.  修改数据库配置为本地/测试数据库地址,并在该数据库执行项目根路径下的 gen.sql 脚本,初始化数据库实例,表结构
3.  更改本地maven settings 为 项目根路径下的 settings.xml
4.  mvn clean
5.  mvn install
6.  执行主类 GeneratorApplication main 方法即可成功运行

#### 使用说明

1.  新建连接

![新建并测试连接](https://images.gitee.com/uploads/images/2021/0722/132942_310d8d77_1694096.png "微信截图_20210722132925.png")
    
2.  新建模板

![新建模板](https://images.gitee.com/uploads/images/2021/0722/133030_29f709eb_1694096.png "屏幕截图.png")
    
3.  新建配置

在配置记录中,选择需要生成的连接,表清单,以及需要生成的模板清单,按照提示进行配置包名等表单项
    
![新建配置](https://images.gitee.com/uploads/images/2021/0722/133142_2a0cb7a7_1694096.png "屏幕截图.png")

4.  生成代码

点击生成,会按照配置记录中的信息进行生成代码,并打成压缩包,根据配置的一键导入脚本生成.bat文件,也会打进压缩包中
    
![生成代码](https://images.gitee.com/uploads/images/2021/0722/133232_fba3b423_1694096.png "屏幕截图.png")

5.  下载代码

![下载代码](https://images.gitee.com/uploads/images/2021/0722/133514_c7abed9d_1694096.png "屏幕截图.png")

6.  一键导入

将下载下来的zip源码压缩包解压,双击执行copy.bat脚本,将代码一键导入本地项目下 (暂时只支持windows版本的脚本,mac可以自行修改该脚本内容及文件后缀名)
    
![一键导入本地项目](https://images.gitee.com/uploads/images/2021/0722/133634_91a14bb3_1694096.png "屏幕截图.png")

#### 参与贡献

1.  Fork 本仓库
2.  新建分支
3.  提交代码
4.  新建 Pull Request

