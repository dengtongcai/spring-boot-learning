package me.datoucai.web.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @author cc
 * @date 2019/1/22
 */
@Configuration
public class SelfConverterConfiguration {

    @Bean
    HttpMessageConverter newBase64Converter() {
        return new Base64HttpMessageConverter();
    }
}
