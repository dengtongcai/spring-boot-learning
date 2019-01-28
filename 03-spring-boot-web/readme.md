统一异常处理
- 对指定的包或者类统一处理
    - @RestControllerAdvice(basePackageClasses = {ExceptionController2.class, ExceptionController.class})
- Mvc错误页面重定向
    - MvcErrorViewResolver implements ErrorViewResolver

自定义content-type（消息转换器）
- Base64HttpMessageConverter extends AbstractHttpMessageConverter<Serializable>
- 添加为@Bean

Spring HATEOAS 和 HAL