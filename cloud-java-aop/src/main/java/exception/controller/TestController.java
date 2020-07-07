package exception.controller;


import exception.consts.ApiExceptionConsts;
import exception.entity.Staff;
import exception.service.StaffService;
import exception.util.GetStaffRequest;
import exception.util.GetStaffResponse;
import exception.util.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author shill
 * @Created 2019-05-05.
 * @Version v1.0
 * @description com.demo.Controller
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Resource
    private StaffService staffService;

    @PostMapping(
            consumes = {"application/json;charset=UTF-8", "application/xml;charset=UTF-8"},
            produces = {"application/JSON;charset=UTF-8", "application/XML;charset=UTF-8"},
            value = "queryStaff")
    public Response<GetStaffResponse> queryStaff(@Valid @RequestBody GetStaffRequest request) {
        Response<GetStaffResponse> result = new Response<>();
        GetStaffResponse getStaffResponse = new GetStaffResponse();
        Long staffId = request.getStaffId();
        Staff staff = staffService.getStaff(staffId);


//        if(!staffId.equals("123")){
//            throw new ServiceException(ResultEnum.ERROR_406);
//        }
//        if(staff==null){
//            getStaffResponse.setStaffDesc("");
//            getStaffResponse.setStaffName("");
//            result.setParam(getStaffResponse);
//            result.setResultCode(ApiExceptionConsts.API_ERROR_CODE);
//            return result;
//        }
        getStaffResponse.setStaffName(staff.getStaffName());
        getStaffResponse.setStaffDesc(staff.getStaffDesc());
        result.setParam(getStaffResponse);
        result.setResultCode(ApiExceptionConsts.API_SUCCESS_CODE);
        return result;
    }

}
