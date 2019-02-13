package me.datoucai.validation.adapter;

import me.datoucai.validation.resolver.TaskHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author cc
 * @date 2019/2/13
 */
@Configuration
public class TaskArgumentResolverConfigurer implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TaskHandlerMethodArgumentResolver());
    }
}
