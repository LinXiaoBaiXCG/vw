<h1 style="text-align: center">微问</h1>
<div style="text-align: center">

![AUR](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)

</div>

#### 项目简介
一个基于 Spring Boot 2.0.1 、 Spring Cloud(Finchley.M9)、MyBatis-plus、Redis、Vue的前后端分离的问答类应用

#### 项目源码

|     |   后端源码  |   前端源码  |
|---  |--- | --- |
|  github   |  https://github.com/LinXiaoBaiXCG/vw   |  https://github.com/LinXiaoBaiXCG/vw-web   |

#### 主要特性
* 使用成熟的技术栈，社区资源丰富。
* 项目按功能模块化，提升开发，测试效率。
* 项目结构清晰，便于阅读。
* 自定义认证注解，可对某一接口拦截与放行。
* 基于snowflake算法的分布式唯一ID生成，保证在分布式环境下,生成全局唯一ID。

####  系统功能
* 用户登录、创建问题、回答问题、个人信息查看等基础功能
* 点赞回答功能
* 搜索回答功能
* 关注功能

#### 项目结构
项目采用按功能分模块开发方式，将通用的配置放在公共模块
- admin_common 后台系统公共模块
    - annotation 为系统自定义注解
    - aspect 自定义注解的切面
    - base 提供了Entity、DTO基类和mapstruct的通用mapper
    - config 自定义权限实现、redis配置、swagger配置
    - exception 项目统一异常的处理
    - utils 系统通用工具类
- admin_generator 后台系统代码生成模块
- admin_logging 后台系统日志模块
- vw_admin 后台系统核心模块（系统启动入口）
	- config 配置跨域与静态资源，与数据权限
	    - thread 线程池相关
	- modules 系统相关模块(登录授权、系统监控、定时任务等)
- vw_common 公共模块
- vw_eureka 注册中心模块
- vw_follow 关注模块
- vw_qa 回答模块
- vw_search 搜索模块
- vw_user 用户模块
- vw_zuul 网关模块

#### 技术选型
* 核心框架：Spring Boot 2.0.1
* 分布式框架：SpringCloud Finchley.M9
* 持久层框架：mybatis-plus 3.1.1
* 日志管理：SLF4J、Log4j
* 搜索框架：elasticsearch、IK分词器、logstash

#### TODO
* 评论模块，通知模块开发
* 集成配置中心，使用Bus总线事实更新配置
* 后台管理系统开发