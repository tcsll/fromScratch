package exception.util;

/**
 * @Created by jiang.jiayang on 2019-05-17.
 * @Version v1.0
 * @description com.ztesoft.bss.market.thtrue.util
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
public class ResponseUtil {
    public static Response error(ResultEnum StatusCode) {
        return new Response(null,StatusCode.getCode()+"", StatusCode.getMsg());
    }

    public static Response error(ResultEnum StatusCode, String message) {
        return new Response(null,StatusCode.getCode()+"", message);
    }
}
