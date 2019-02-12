package me.datoucai.validation.constraint;

import me.datoucai.validation.annotation.Idcard;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义约束校验器
 *
 * @author cc
 * @date 2019/2/12
 */
@Configuration
public class IdcardConstraintValidator implements ConstraintValidator<Idcard, String> {
    private static final int[] WI = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final String[] VI = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
    private static final int INTERVAL = 120;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!isIdCard18(value)) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(Idcard constraintAnnotation) {
        System.out.println(constraintAnnotation);
    }

    /**
     * 验证是否18位身份证号
     *
     * @param str
     * @return
     */
    private static boolean isIdCard18(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        String regex = "(^\\d{18}$)|(^\\d{17}[Xx]$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean flag = false;
        if (matcher.matches()) {
            String oVerifyBit = str.substring(17);
            String nVerifyBit = getVerifyBit(str.substring(0, 17));

            LocalDate now = LocalDate.now();
            int sysYear = now.getYear();
            int year = Integer.parseInt(str.substring(6, 10));
            int month = Integer.parseInt(str.substring(10, 12));
            int day = Integer.parseInt(str.substring(12, 14));

            if (StringUtils.equalsIgnoreCase(oVerifyBit, nVerifyBit)
                    && year >= (sysYear - INTERVAL) && year <= sysYear
                    && month > 0 && month < 13
                    && day > 0 && day < 32) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取18位身份证的校验位
     *
     * @param str 身份证前17位
     * @return 结果
     */
    private static String getVerifyBit(String str) {
        if (StringUtils.isBlank(str) || str.length() != 17) {
            return null;
        }
        int[] ai = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ai[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        int num = 0;
        for (int i = 0; i < 17; i++) {
            num += ai[i] * WI[i];
        }
        int remaining = num % 11;
        return VI[remaining];
    }
}
