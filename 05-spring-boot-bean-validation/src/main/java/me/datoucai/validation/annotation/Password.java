package me.datoucai.validation.annotation;

import me.datoucai.validation.constraint.PasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author cc
 * @date 2019/2/12
 */
@Documented
@Constraint(validatedBy = {PasswordConstraintValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface Password {

    String message() default "{me.datoucai.validation.annotation.Password.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return an additional regular expression the annotated element must match. The default
     * is any string ('.*')
     */
    String regexp() default ".*";

    /**
     * @return used in combination with {@link #regexp()} in order to specify a regular
     * expression option
     */
    Pattern.Flag[] flags() default {};
}
