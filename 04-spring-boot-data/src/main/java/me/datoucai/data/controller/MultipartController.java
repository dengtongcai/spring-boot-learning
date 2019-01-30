package me.datoucai.data.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.datoucai.data.jpa.extra.ExtraMultipartUserRepository;
import me.datoucai.data.jpa.master.MasterMultipartUserRepository;
import me.datoucai.data.jpa.slave.SlaveMultipartUserRepository;
import me.datoucai.data.vo.MultipartUser;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author cc
 * @date 2019/1/30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
public class MultipartController {

    @NonNull
    private final MasterMultipartUserRepository masterMultipartUserRepository;
    @NonNull
    private final SlaveMultipartUserRepository slaveMultipartUserRepository;
    @NonNull
    private final ExtraMultipartUserRepository extraMultipartUserRepository;


    @GetMapping("/user/master")
    public List<MultipartUser> master() {
        return masterMultipartUserRepository.findAll();
    }

    @GetMapping("/user/slave")
    public List<MultipartUser> slave() {
        return slaveMultipartUserRepository.findAll();
    }

    @GetMapping("/user/extra")
    public List<MultipartUser> extra() {
        return extraMultipartUserRepository.findAll();
    }


    @PostMapping("/add/master")
    public MultipartUser addMaster(@RequestBody MultipartUser user) {
        user.setDesc("master");
        return masterMultipartUserRepository.save(user);
    }

    @PostMapping("/add/slave")
    public MultipartUser addSlave(@RequestBody MultipartUser user) {
        user.setDesc("slave");
        return slaveMultipartUserRepository.save(user);
    }

    @PostMapping(value = "/add/extra")
    public MultipartUser addExtra(@RequestBody @Valid MultipartUser user) {
        user.setDesc("extra");
        return extraMultipartUserRepository.save(user);
    }
}
