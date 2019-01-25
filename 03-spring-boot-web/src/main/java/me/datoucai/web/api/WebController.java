package me.datoucai.web.api;

import lombok.extern.slf4j.Slf4j;
import me.datoucai.web.vo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

/**
 * @author cc
 * @date 2019/1/17
 */
@Slf4j
@RestController
public class WebController {

    @GetMapping(value = "/web", produces = "application/json")
    public User web() {
        return User.builder().name("dtc").age("666").build();
    }

    @GetMapping(value = "protobuf", produces = "application/x-protobuf")
    public User protobuf() {

        return User.builder().name("dtc").age("666").build();
    }

    @RequestMapping(value = "/converter", consumes = "application/x-base;charset=utf-8", produces = "application/x-base;charset=utf-8")
    public User Base64Converter(@RequestParam String msg) {
        log.info(msg);
        return User.builder().name("dtc").age("666").build();
    }
}
