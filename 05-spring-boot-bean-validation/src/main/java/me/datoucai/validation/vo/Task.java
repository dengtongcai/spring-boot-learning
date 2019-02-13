package me.datoucai.validation.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.datoucai.validation.annotation.Idcard;
import me.datoucai.validation.annotation.Password;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@JsonInclude(Include.NON_EMPTY)
public class Task extends BaseTask implements Cloneable {

    private static final long serialVersionUID = 1L;
    /**
     * 手机号
     */
    @NotBlank(message = "account must not be blank")
    @Pattern(regexp = "(^1[3456789]\\d{9}$)", message = "account is illegal")
    String account;
    /**
     * 账户密码
     */
//    @NotBlank(message = "password must not be blank")
//    @Pattern(regexp = "^(\\d{6}){1}(\\d{2})?$", message = "password len must be 6 or 8")
    @Password(message = "password length must be 6 or 8")
    String password;

    /**
     * 身份证号
     */
    @NotBlank(message = "idCard must not be blank")
    @Idcard(message = "idcard is illegal")
    @JSONField(name = "id_card")
    @JsonProperty("id_card")
    String idCard;
    /**
     * 用户真实姓名
     */
    @NotBlank(message = "realName must not be blank")
    @Pattern(regexp = "^[\u2E80-\u9FFF]{1,20}[·.]{0,1}[\u2E80-\u9FFF]{1,20}$", message = "realName is illegal")
    @JSONField(name = "real_name")
    String realName;

    /**
     * 唯一标识
     */
    @Size(max = 512, message = "user_id too long, max len is 512")
    @JSONField(name = "user_id")
    private String userId;
    /**
     * 登录方式
     */
    @JSONField(name = "login_type")
    private String loginType;
    /**
     * 省份编码
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 运营商类型
     */
    @JSONField(name = "yysd_type")
    private String yysdType;
    /**
     * 是否自动图片打码
     */
    @JSONField(name = "auto_captcha")
    private String autoCaptcha;


    @Override
    public Task clone() {
        try {
            return (Task) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Task();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
