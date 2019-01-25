package me.datoucai.web.api;

import com.alibaba.fastjson.JSON;
import me.datoucai.web.exception.CustomException;
import me.datoucai.web.vo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.Map;

/**
 * @author cc
 * @date 2019/1/24
 */
@RestController
public class ExceptionController2 {

    @RequestMapping(value = "exp5", produces = "application/json;charset=utf-8")
    public User exceptionInfo1(HttpRequestHandlerServlet request, @RequestBody String data) {
        System.out.println(data);
        System.out.println(1 / 0);
        return User.builder().name("success").age("666").build();
    }
}
