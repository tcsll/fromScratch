package exception.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author shill
 * @Created 2019-05-20.
 * @Version v1.0
 * @description com.demo.Bo
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("staff")
public class Staff {
    @TableId
    @TableField(value = "staff_id")
    private String staffId;
    @TableField(value = "staff_name")
    private String staffName;
    @TableField(value = "staff_desc")
    private String staffDesc;
    @TableField(value = "phone")
    private String phone;
}


