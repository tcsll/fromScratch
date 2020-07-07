package exception.util;

import exception.constraint.Phone;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

/**
 * @author shill
 * @Created 2019-05-17.
 * @Version v1.0
 * @description com.ztesoft.bss.market.thtrue.util
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
@Getter
@Setter
public class GetStaffRequest {
    @NotNull(message = "staffId is required")
    private Long staffId;
    private String staffName;
    @Phone
    private Long phone;
}
