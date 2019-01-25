package me.datoucai.web.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @author cc
 * @date 2019/1/24
 */
@Data
@Builder
public class CustomException extends RuntimeException {
    private int code;
    private String message;
}
