# learning_platform
自主学习平台

## 前端技术/框架: Jquery,Easyui,HTML5,Layer弹出层

## 后端技术/框架: JAVA,Spring,SpringMVC,Mybatis,Quartz

## 数据库: MySQL5.x

## 缓存: Redis

## 总体架构: 

采用MAVEN搭建及部署;

Redis做为缓存(故需要做redis配置,一般在项目resource.properties中),因为做了try-catch来保证redis不影响项目,所以也可不配置,不过控制台会一直输出exception就是了

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

## SQL

edu.sql文件

数据库名：edu

## 项目中配置说明

db.properties 为数据库配置

resource.properties 为redis配置和一些其他的配置(因为是个人项目就没怎么整理)

url.properties(edu-protal项目中) 为对应restful服务地址

## 导入完成项目后说明

edu-parent 需运行 run as -> maven install 

edu-common 需运行 run as -> maven install

quinFS 文件服务器可一直运行，edu-manager采用flash上传组件时需要上传到quinFS中,文件存放在webapp目录下的file文件夹中(可见有多简陋了哈哈)

edu-manager 需在前两个运行完成后再运行 run as -> maven build , 若运行失败，请检查数据库配置,运行成功后地址 localhost:8080/edu-manager/

edu-rest 需在前两个运行完成后再运行 run as -> maven build

edu-protal 需在edu-rest运行后再运行,运行成功后地址 localhost:81/

## 最后说明

该项目为个人写出来的项目，本人也正在学习，所以里面许多东西比较的乱。


