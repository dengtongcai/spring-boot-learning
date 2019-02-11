package me.datoucai.data.controller;

import me.datoucai.data.jpa.extra.ExtraMultipartUserRepository;
import me.datoucai.data.jpa.master.MasterMultipartUserRepository;
import me.datoucai.data.jpa.slave.SlaveMultipartUserRepository;
import me.datoucai.data.vo.MultipartUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author cc
 * @date 2019/1/30
 */
@RestController
@RequestMapping("/data")
public class MultipartController {

    @Autowired
    private MasterMultipartUserRepository masterMultipartUserRepository;
    @Autowired
    private SlaveMultipartUserRepository slaveMultipartUserRepository;
    @Autowired
    private ExtraMultipartUserRepository extraMultipartUserRepository;


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
        user.setDescription("master");
        return masterMultipartUserRepository.save(user);
    }

    @PostMapping("/add/slave")
    public MultipartUser addSlave(@RequestBody MultipartUser user) {
        user.setDescription("slave");
        return slaveMultipartUserRepository.save(user);
    }

    @PostMapping(value = "/add/extra")
    public Object addExtra(@RequestBody @Validated MultipartUser user, BindingResult br) {
        if (br.hasErrors()) {
            List<ObjectError> allErrors = br.getAllErrors();
            ArrayList<String> err = new ArrayList<>();
            allErrors.forEach((error) -> {
                err.add(error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            });
            return err;
        }
        user.setDescription("extra");
        return extraMultipartUserRepository.save(user);
    }

    @GetMapping(value = "/all/user")
    public Collection<MultipartUser> all() {
        List<MultipartUser> master = masterMultipartUserRepository.findAll();
        List<MultipartUser> slave = slaveMultipartUserRepository.findAll();
        List<MultipartUser> extra = extraMultipartUserRepository.findAll();

        List<MultipartUser> all = new ArrayList<>();
        all.addAll(master);
        all.addAll(slave);
        all.addAll(extra);

        return all;
    }
}
