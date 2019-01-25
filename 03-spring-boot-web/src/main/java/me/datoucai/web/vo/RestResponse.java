package me.datoucai.web.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author cc
 * @date 2019/1/24
 */
@Data
@Builder
public class RestResponse {
    private int code;
    private String message;
    private String detail;
}
