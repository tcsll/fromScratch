package exception.service;

import exception.entity.Staff;
import exception.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shill
 * @Created 2019-05-20.
 * @Version v1.0
 * @description com.demo.service
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
@Service
public class StaffService {
    @Resource
    private StaffMapper staffMapper;

    public Staff getStaff(Long staffId) {
        return staffMapper.getStaffById(staffId);
    }
}
