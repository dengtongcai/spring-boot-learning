package me.datoucai.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @date 2019/1/23
 */
@Controller
public class PageController {
    @RequestMapping(value = "home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "login")
    public String login() {
        return "login";
    }
}
