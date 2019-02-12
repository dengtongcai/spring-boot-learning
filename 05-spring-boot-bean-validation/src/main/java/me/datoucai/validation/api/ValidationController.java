package me.datoucai.validation.api;

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
//    @Autowired
//    HttpServletRequest request;

    @PostMapping(value = "/YYSD/task/create", produces = "application/json;charset=UTF-8")
    public String taskCreate(HttpServletRequest request, @RequestBody @Valid Task task) {
        System.out.println(task);
        return request.getRequestURI();
    }
}
