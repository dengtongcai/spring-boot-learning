package me.datoucai.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @date 2019/1/17
 */
@RestController
public class WebController {

    @GetMapping(value = "/web")
    public String web() {
        return "hello web !!!";
    }
}
