package exception.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Created by jiang.jiayang on 2019-05-17.
 * @Version v1.0
 * @description com.ztesoft.bss.market.thtrue.util
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T>{
    private T param;//参数
    private String resultCode;//结果码
    private String resultInfo;//结果说明

}
