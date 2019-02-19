package me.datoucai.sharding.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author cc
 * @date 2019/2/18
 */
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String tel;

    private String email;

    @JSONField(name = "web_site")
    @JsonProperty(value = "web_site")
    private String webSite;

    private String address;

    private String introduction;
}
