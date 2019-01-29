package me.datoucai.data.controller;

import com.alibaba.fastjson.JSON;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.datoucai.data.jpa.UserRepository;
import me.datoucai.data.vo.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author cc
 * @date 2019/1/29
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/data/user")
public class UserController {

    @NonNull
    private UserRepository userRepository;

    @GetMapping(value = "/id/{id}")
    public String getUser(@PathVariable Integer id) {
        Optional<User> one = userRepository.findById(id);
        return JSON.toJSONString(one);
    }

    @GetMapping(value = "/name/{name}")
    public String getUser(@PathVariable String name) {
        User one = userRepository.findByName(name);
        return JSON.toJSONString(one);
    }

    @GetMapping(value = "/param/{name}/{age}")
    public String getUser(@PathVariable String name, @PathVariable Integer age) {
        List<User> one = userRepository.findByHql(age);
        List<User> bySql = userRepository.findBySql(name, age);
        List<Object> emptyList = new ArrayList<>();
        emptyList.addAll(one);
        emptyList.addAll(bySql);
        return JSON.toJSONString(emptyList);
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody @Valid User user) {
//        User user = JSON.parseObject(data, User.class);
        @Valid User save = userRepository.save(user);
        return JSON.toJSONString(save);
    }
}
