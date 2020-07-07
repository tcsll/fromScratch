package exception.constraint;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @Created 2019-05-20.
 * @Version v1.0
 * @description com.demo.Constraint 接着实现参数验证的类
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private boolean required = false;
    // 定义的手机号验证正则表达式
    private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public void initialize(Phone constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required) {
            return pattern.matcher(s).matches();
        }else {
            if(StringUtils.isEmpty(s)) {
                return false;
            }else{
                return pattern.matcher(s).matches();
            }
        }
    }
}
