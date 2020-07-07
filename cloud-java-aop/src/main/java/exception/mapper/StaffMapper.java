package exception.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import exception.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @author shilll
 * @Created by jiang.jiayang on 2019-05-20.
 * @Version v1.0
 * @description com.demo.repository
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */

public interface StaffMapper extends BaseMapper<Staff> {
    @Select("select * from staff where staff_id= #staffId")
    Staff getStaffById(@Param("staff_id") Long staffId);
}
