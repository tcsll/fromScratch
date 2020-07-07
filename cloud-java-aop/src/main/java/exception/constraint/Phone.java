package exception.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author shill
 * @Created on 2019-05-05
 * @Version v1.0
 * @description com.demo.Constraint  手机号的验证注解
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    boolean required() default true;

    // 这个地方修改错误提示字符，其他地方不要修改
    String message() default "phone format is error,please check!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
