生成Git信息，也可以作为存活检测接口
```java
<groupId>pl.project13.maven</groupId>
<artifactId>git-commit-id-plugin</artifactId>
<version>2.2.4</version>
```

JPA单数据源查询me.datoucai.data.jpa.UserRepository
JPA多数据源
- @Primary
- jdbc-url而不是url
- Caused by: java.lang.IllegalArgumentException: Not a managed type: class me.datoucai.data.vo.MultipartUser
.packages("me.datoucai.data.vo") 写错
- org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'extraTransactionManager' is expected to be of type 'org.springframework.transaction.PlatformTransactionManager' but was actually of type 'com.sun.proxy.$Proxy89
@Bean(name = "extraTransactionManager")注解到其他对象了
- MySQL关键字占用`desc`