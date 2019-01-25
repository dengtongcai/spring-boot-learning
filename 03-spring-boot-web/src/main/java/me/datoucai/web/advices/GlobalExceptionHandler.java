package me.datoucai.web.advices;

import com.alibaba.fastjson.JSONException;
import me.datoucai.web.exception.CustomException;
import me.datoucai.web.vo.RestResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cc
 * @date 2019/1/24
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public RestResponse resoveCustomException(HttpServletRequest req, CustomException e) {
        e.printStackTrace();
        return RestResponse.builder().code(e.getCode()).message(e.getMessage()).build();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public RestResponse resoveRuntimeException(HttpServletRequest req, RuntimeException e) {
        if(e instanceof JSONException){
            if (!"application/json".equalsIgnoreCase(req.getHeader("Content-Type"))){
               return  RestResponse.builder().code(406).message("请求参数类型content-type错误").detail(e.getMessage()).build();
            }else {
                return RestResponse.builder().code(406).message("请求参数内容错误").detail(e.getMessage()).build();
            }
        }
        return RestResponse.builder().code(500).message(e.getMessage()).build();
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
