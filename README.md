# spring-boot-learning
learn springboot step by step

## 01-spring-boot-external-config
### 配置专用类@ConfigurationProperties
- @DateTimeFormat 字符串转时间

### 外部化配置
- @Value
- Environment 自带外部化配置类

## 02-spring-boot-profiles
### 多配置文件
- spring.profiles.active=devp
### 日志配置
- 日志级别
    - logging.level.root=info
- 指定类日志级别
    - logging.level.me.datoucai.profiles.api.ProfilesController=debug
- 日志文件和路径配置
    - logging.file=.//02-spring-boot-profiles//profiles.log
    
## 03-spring-boot-web
### 统一异常处理
- 对指定的包或者类统一处理
    - @RestControllerAdvice(basePackageClasses = {ExceptionController2.class, ExceptionController.class})
- Mvc错误页面重定向
    - MvcErrorViewResolver implements ErrorViewResolver
- 疑问调用me.datoucai.web.advices.GlobalExceptionHandler.handleExceptionInternal

### 自定义content-type（消息转换器）
- Base64HttpMessageConverter extends AbstractHttpMessageConverter<Serializable>
- 添加为@Bean

### Spring HATEOAS 和 HAL

## 04-spring-boot-data
### 生成Git信息，也可以作为存活检测接口
```java
<groupId>pl.project13.maven</groupId>
<artifactId>git-commit-id-plugin</artifactId>
<version>2.2.4</version>
```
### JPA
JPA单数据源查询me.datoucai.data.jpa.UserRepository

JPA多数据源
- @Primary
- jdbc-url而不是url
- Caused by: java.lang.IllegalArgumentException: Not a managed type: class me.datoucai.data.vo.MultipartUser
.packages("me.datoucai.data.vo") 写错
- org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'extraTransactionManager' is expected to be of type 'org.springframework.transaction.PlatformTransactionManager' but was actually of type 'com.sun.proxy.$Proxy89
@Bean(name = "extraTransactionManager")注解到其他对象了
- MySQL关键字占用`desc`

## 05-spring-boot-bean-validation
### 自定义validation的约束
- @Idcard
- @Password
- 包constraint

### 自定义参数绑定解析器
- 使用jackson别名注解@JsonProperty
- @RequestTask
- TaskHandlerMethodArgumentResolver
