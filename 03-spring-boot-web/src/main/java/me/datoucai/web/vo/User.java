package me.datoucai.web.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cc
 * @date 2019/1/22
 */
@Builder
@Data
public class User implements Serializable {
    private String name;
    private String age;
}
