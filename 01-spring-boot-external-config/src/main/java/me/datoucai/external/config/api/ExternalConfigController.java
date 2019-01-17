package me.datoucai.external.config.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @date 2019/1/17
 */
@RestController
public class ExternalConfigController {

    @GetMapping(value = "/config")
    public String config() {
        return "hello cnofig !!!";
    }

}
