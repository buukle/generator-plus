# buukle-generator

#### 介绍
布壳儿脚手架服务

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
2.  新建模板
3.  新建配置
4.  生成代码
5.  下载代码并一键导入


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

