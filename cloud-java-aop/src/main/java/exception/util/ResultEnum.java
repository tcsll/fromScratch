package exception.util;

/**
 * @Created by jiang.jiayang on 2019-05-17.
 * @Version v1.0
 * @description com.ztesoft.bss.market.thtrue.util
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
public enum ResultEnum {
    SUCCESS(0,"成功"),//成功
    PARAM_ERROR(-1,"参数错误"),
    FAIL(400,"失败"),//失败
    UNAUTHORIZED(401,"未认证"),//未认证（签名错误）
    NOT_FOUND(404,"接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),//服务器内部错误
    RUNTIME_ERROR(600,"运行时异常"),
    NULL_POINT(601,"空指针异常"),
    IO_error(602,"IO异常"),
    UNKNOW_ERROR(603,"未知方法异常"),
    IndexOutOfBounds(604,"数组越界"),
    ERROR_405(405,"405异常"),
    ERROR_406(406,"这人太帅，导致异常");





    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
