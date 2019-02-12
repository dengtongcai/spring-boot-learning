package me.datoucai.validation.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(Include.NON_EMPTY)
public class BaseTask implements Serializable {

    /**
     * 任务主键，自增，按照id分片
     */
    @JSONField(serialize = false)
    private Integer id;

    /**
     * 商户唯一号
     */
    @JSONField(serialize = false)
    private String appId;

    /**
     * 任务的唯一id
     */
    @JSONField(serialize = false)
    private String taskKey;

    /**
     * 任务创建时间
     */
    @JSONField(serialize = false)
    private Date createTime;

    /**
     * 任务完成时间
     */
    @JSONField(serialize = false)
    private Date finishTime;

    /**
     * 业务类型
     */
    @JSONField(serialize = false)
    private String product;

    /**
     * 任务所处阶段
     */
    @JSONField(serialize = false)
    private String phrase;

    /**
     * 服务方编号
     */
    @JSONField(serialize = false)
    private String serviceSupplierNo;

    /**
     *
     */
    @JSONField(serialize = false)
    private String MD5;

    /**
     * 服务接入方式，0(h5), 1(sdk), 2(api)
     */
    private Integer origin;

    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    private Date updateTime;

    /**
     * 接入第三方时唯一id值，如果没有可以自己生成
     */
    @JSONField(serialize = false)
    private String thirdKey;


    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "{}";
        }
    }

}
