package exception.util;

import org.springframework.stereotype.Component;

/**
 * @Created by jiang.jiayang on 2019-05-17.
 * @Version v1.0
 * @description 业务异常类
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
@Component
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer code;  //错误码

    public ServiceException() {}

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
