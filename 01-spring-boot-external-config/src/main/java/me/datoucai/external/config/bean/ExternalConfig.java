package me.datoucai.external.config.bean;

import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * @author cc
 * @date 2019/1/16
 */
@Configuration
public class ExternalConfig {
    {
        RandomValuePropertySource my = new RandomValuePropertySource("my");
        System.out.println(my.getProperty("random.int"));
    }
}
