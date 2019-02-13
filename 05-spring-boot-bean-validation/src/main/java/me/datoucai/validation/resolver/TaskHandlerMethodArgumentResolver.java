package me.datoucai.validation.resolver;

import com.alibaba.fastjson.JSON;
import me.datoucai.validation.annotation.RequestTask;
import me.datoucai.validation.vo.Task;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author cc
 * @date 2019/2/13
 */
@Configuration
public class TaskHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    //这个方法是用来判断对应的参数是否支持被解析，要满足：注解+类型
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Task.class.isAssignableFrom(parameter.getParameterType()) && parameter.hasParameterAnnotation(RequestTask.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Task task = new Task();
        if (Task.class.isAssignableFrom(parameter.getParameterType()) && parameter.hasParameterAnnotation(RequestTask.class)) {
            HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
            Assert.state(servletRequest != null, "No HttpServletRequest");
            ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(servletRequest);
            InputStream body = inputMessage.getBody();

            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = body.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            String params = result.toString("utf-8");
            task = JSON.parseObject(params, Task.class);
        }
        return task;
    }
}
