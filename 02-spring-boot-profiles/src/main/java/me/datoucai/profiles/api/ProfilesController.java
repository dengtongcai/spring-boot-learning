package me.datoucai.profiles.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @date 2019/1/17
 */
@RestController
public class ProfilesController {

    @GetMapping(value = "/profiles", produces = "application/json;charset=utf-8")
    public String profiles() {
        return "hello profiles !!!";
    }
}
