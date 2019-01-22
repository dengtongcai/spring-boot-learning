package me.datoucai.profiles.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @date 2019/1/17
 */
@Slf4j
@RestController
public class ProfilesController {
    @Value("${config.level}")
    private String level;

    @GetMapping(value = "/profiles", produces = "application/json;charset=utf-8")
    public String profiles() {
        String res = level;

        log.debug("level is {}", level);
        log.info("level is {}", level);
        log.warn("level is {}", level);
        log.error("level is {}", level);
        log.info("the log system is {}",log);
        return level;
    }
}
