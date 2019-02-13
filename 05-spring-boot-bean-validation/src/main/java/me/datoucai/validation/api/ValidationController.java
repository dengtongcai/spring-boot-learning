package me.datoucai.validation.api;

import me.datoucai.validation.annotation.RequestTask;
import me.datoucai.validation.vo.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author cc
 * @date 2019/2/12
 */
@RestController
@RequestMapping("/api-gateway")
public class ValidationController {

    @PostMapping(value = "/YYSD/task/create", produces = "application/json;charset=UTF-8")
    public String taskCreate(HttpServletRequest request, @RequestBody @Valid Task task) {
        System.out.println(task);
        return request.getRequestURI();
    }

    @PostMapping(value = "/YYSD/task/request", produces = "application/json;charset=UTF-8")
    public String requestTask(HttpServletRequest request, @RequestTask @Valid Task task) {
        System.out.println(task);
        return request.getRequestURI();
    }
}
