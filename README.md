## 社区项目


## 参考资料
[Spring doc](https://spring.io)
[thymeleaf前端渲染](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#parameterizable-fragment-signatures)
[spring 初始化](https:spring.io/guides)

[对比站点](https://elasticsearch.cn.explore)

[bootstrap](https://v3.bootcss.com/getting-started/)
##工具
[Git](https://git-scm.com/download)

[visual paradigm](https://www.visual-paradigm.com)
[okhttp便于get post请求](https://square.github.io/okhttp/)
[spring-boot-mybatis](https://docs.spring.io/spring-boot/docs/2.2.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)
[mybatis-spring-configure mapper](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
[flyway] (https://flywaydb.org/documentation/getstarted/why)
## .sql  ; mvn flyway migration
[lomebook](https://projectlombok.org/setup/maven)
####@Data自动生产get,set
####github目前只支持令牌接入   https://yourtoken@github.com/931986/community.git
####git remote set-url origin  https://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@github.com/931986/community.git
####cookie保存登录状态
[spring-dev-tools](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)

##授权github登录的参考站点
[Github api doc]https://docs.github.com/cn/developers/apps/building-oauth-apps/creating-an-oauth-app
##过程
####1.登录
#### authorize
#### 客户端回调redire-url
####客户端请求获取accessToken以及code
#### 返回accessToken携带code

####常见question
####textareas th:text不能回显，改成th:text
####fastjson可以将下划线映射到驼峰属性
#### h2数据库轻量级mysql
#### [dataformat详解]（https://www.w3school.com.cn/sql/func_date_format.asp）

```
create table USER
(
ID INTEGER auto_increment,
ACCOUNT_ID VARCHAR(100),
NAME VARCHAR(50),
TOKEN CHAR(50),
GMT_CREATE BIGINT,
GMT_MODIFIED BIGINT
);
```
#### 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
#### git push  time out 失败解决方案
#### git config --global --unset http.proxy





####  表述关系图
####   泛化关系  ->
####   实现关系 --->
####  聚合关系
#### 组合关系 整体和部分 强依赖
####  关联关系
####  依赖关系
####  实箭泛化虚实现
## Mysql:  https://www.runoob.com/mysql/mysql-tutorial.html
#### Database->table->recode
#### crud
#### sql命令
IoC（Inverse of Control:控制反转）是一种设计思想 或者说是某种模式。这个设计思想就是 将原本在程序中手动创建对象的控制权，交由 Spring 框架来管理。 IoC 在其他语言中也有应用，并非 Spring 特有。IoC 容器是 Spring 用来实现 IoC 的载体， IoC 容器实际上就是个 Map（key，value）,Map 中存放的是各种对象。
使用的时候直接向 IoC 容器 “要” 就可以了。IoC 最常见以及最合理的实现方式叫做依赖注入（Dependency Injection，简称 DI）。

AOP：Aspect oriented programming 面向切面编程，AOP 是 OOP（面向对象编程）的一种延续。
在不改变原有业务逻辑的情况下，增强横切逻辑代码，根本上解耦合，避免横切逻辑代码重复。

