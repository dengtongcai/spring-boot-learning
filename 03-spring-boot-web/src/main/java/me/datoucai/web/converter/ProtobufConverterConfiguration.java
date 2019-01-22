package me.datoucai.web.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author cc
 * @date 2019/1/22
 */
@Configuration
public class ProtobufConverterConfiguration {

    void print(){
        System.out.println("ooooooooooooooo");
    }

    void printOff(){
        System.out.println("lllllllllllllll");
    }

    // 使用 protobuf 作为消息协议(序列化)
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
    // 配置restTeamplete 解析 protobuf（反序列化)
    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
        return new RestTemplate(Collections.singletonList(hmc));
    }
}
