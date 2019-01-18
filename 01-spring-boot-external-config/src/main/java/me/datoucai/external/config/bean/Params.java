package me.datoucai.external.config.bean;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author cc
 * @date 2019/1/18
 */
@Data
@ToString
public class Params {

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "密码不能为空")
    private String password;
}
