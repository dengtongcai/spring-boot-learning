package me.datoucai.external.config.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cc
 * @date 2019/1/16
 */
@Component
@ConfigurationProperties(prefix = "external")
@Data
public class ExternalConfig {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private List<String> collect;

    private List<String> connection;

    private int notnull;

    private Map<String, String> mm;

}
