package me.datoucai.validation.constraint;

import me.datoucai.validation.annotation.Password;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义约束校验器
 *
 * @author cc
 * @date 2019/2/12
 */
@Configuration
public class PasswordConstraintValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.length() != 6 && value.length() != 8) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(Password constraintAnnotation) {
        System.out.println(constraintAnnotation);
    }
}
