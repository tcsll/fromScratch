package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

/**
 * @author ：shill
 * @date ：Created in 2020/6/12 10:33
 * @description : 测试实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class Model {
    private String id;
    private String name;

    // public String getField(String field){
    //   //  this.
    //
    // }
}
