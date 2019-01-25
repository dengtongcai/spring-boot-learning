package me.datoucai.web.exp;

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
public class ExceptionController {

    @RequestMapping(value = "exp1", produces = "application/json;charset=utf-8")
    public User exceptionInfo1(HttpRequestHandlerServlet request, @RequestBody String data) {
        System.out.println(data);
        System.out.println(1 / 0);
        return User.builder().name("success").age("666").build();
    }

    @RequestMapping(value = "exp2", produces = "application/json;charset=utf-8")
    public User exceptionInfo2(HttpRequestHandlerServlet request, @RequestBody String data) {
        try {
            System.out.println(data);
            System.out.println(1 / 0);
            return User.builder().name("success").age("666").build();
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.builder().code(400).message("不能除以零！！！！").build();
        }
    }

    @RequestMapping(value = "exp3", produces = "application/json;charset=utf-8")
    public User exceptionInfo3(HttpRequestHandlerServlet request, @RequestBody String data) {
        try {
            System.out.println(data);
            Map map = JSON.parseObject(data, Map.class);
            System.out.println(map);
            return User.builder().name("success").age("666").build();
        }  catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
//        catch (JSONException e) {
//            e.printStackTrace();
//            throw CustomException.builder().code(406).message(e.getMessage()).build();
//        }
    }
}
