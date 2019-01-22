package me.datoucai.web.converter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * 自动base64加解密
 *
 * @author cc
 * @date 2019/1/22
 */
@Slf4j
public class Base64HttpMessageConverter extends AbstractHttpMessageConverter<Serializable> {

    public Base64HttpMessageConverter() {
        //x-x-base 是自定义的媒体类型
        super(new MediaType("application", "x-base", Charset.forName("utf-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        //判断是否支持
        // 使用Serializable，这里可以直接返回true
        // 使用object，这里还要加上Serializable接口实现类判断
        // 根据自己的业务需求加上其他判断
        return true;
    }

    @Override
    protected Serializable readInternal(Class<? extends Serializable> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        //解密
        InputStream body = inputMessage.getBody();
        byte[] bytes = Base64.getDecoder().decode(IOUtils.toByteArray(body));
        //转对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        try {
            return (Serializable) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void writeInternal(Serializable serializable, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        log.info(JSON.toJSONString(serializable));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        //加密可视化
        byte[] encode = Base64.getEncoder().encode(byteArrayOutputStream.toByteArray());
        outputMessage.getBody().write(encode);
    }
}
