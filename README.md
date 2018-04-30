# learning_platform
自主学习平台

## 前端技术/框架: Jquery,Easyui,HTML5,Layer弹出层

## 后端技术/框架: JAVA,Spring,SpringMVC,Mybatis

## 数据库: MySQL5.x

## 总体架构: 

采用MAVEN搭建及部署;

Redis做为缓存(故需要做redis配置,一般在项目resource.properties中)

Quartz作业调度来更新统计每门课的点击量(半夜的时候,具体时间忘了,从redis缓存中读取更新)

## 各个项目作用：

edu-manager: 后台管理系统 账号:admin 密码:123456

edu-rest: restful服务(并没有设计得很好,因为还在学习)

edu-protal: 门户页面,采用SSM+freemarker负责调用edu-rest中的接口并进行页面的渲染

edu-common: 封装pojo及对应的mapper还有一些项目中较为常用的工具类, pojo和mapper皆采用mybatis自动生成代码.

edu-parent: pom定义各个项目所需的jar包(或称依赖),plugin插件 及 其版本

quinFS: 文件服务器(极其简陋,主要想试下自己写个分布式文件服务器)

## 项目部署

所有项目皆为MAVEN项目，故导入eclipse时应选择 import -> maven Project -> exists maven project 

运行时选择 Run as -> maven build 利用tomcat插件直接运行 或 部署到 本地tomcat中 方法参考这两篇文章

https://blog.csdn.net/bigwhitetao9527/article/details/80148838   如何通过Maven的Tomcat插件运行Web工程

https://blog.csdn.net/bigwhitetao9527/article/details/79391548    maven自动部署到远程tomcat教程

