package me.datoucai.data.vo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author cc
 * @date 2019/1/29
 */
@Data
@Entity
@Table(name = "user")
public class MultipartUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull(message = "{user.age.不允许为空}")
    private Integer age;
    @NotNull(message = "{user.location不允许为空}")
    private String location;
    private String description;
}
