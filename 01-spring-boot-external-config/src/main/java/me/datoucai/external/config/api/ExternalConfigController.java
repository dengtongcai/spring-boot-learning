package me.datoucai.external.config.api;

import me.datoucai.external.config.bean.ExternalConfig;
import me.datoucai.external.config.bean.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author cc
 * @date 2019/1/17
 */
@RestController
public class ExternalConfigController {

    @Autowired
    private ExternalConfig ec;

    @Autowired
    private Environment evn;

    @Value("${app.name}")
    private String appName;

    @Value("${app.desc}")
    private String desc;

    @Value("${self.uuid}")
    private String uuid;

    @Value("${random.uuid}")
    private String uuid2;

    @GetMapping(value = "/random")
    public String config(@Valid Params params) {
        System.out.println(params);
        RandomValuePropertySource propertySource = new RandomValuePropertySource();
//        return "hello random is：" + propertySource.getProperty("random.int");
//        return "hello random is：" + propertySource.getProperty("random.long");
//        return "hello random is：" + propertySource.getProperty("random.int(10)");
//        return "hello random is：" + propertySource.getProperty("random.value");
//        return "hello random is：" + propertySource.getProperty("random.int[1024,65536]");
//        return desc;
//        return uuid;
//        return evn.getProperty("app.desc");
//        return uuid2;
        return ec.toString();
    }


}
