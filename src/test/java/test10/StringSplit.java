package test10;

import com.alibaba.fastjson.JSONObject;

import java.util.Optional;

/**
 * @author ：shill
 * @date ：Created in 2020/5/11 14:32
 * @description :
 */
public class StringSplit {
    public static void main(String[] args) {
        String str = "1234567890111";
        int n = 4;
        // System.out.println(str.substring(str.length()-3));
        // System.out.println(str.substring(str.length()-n));
        // System.out.println(str.substring(str.length()-5));


        JSONObject jsonObject=new JSONObject();
        jsonObject=jsonObject.fluentPut("test",99).fluentPut("test1","ds");

        System.out.println(Optional.ofNullable(jsonObject.getInteger("test")).orElse(0));
        System.out.println(Optional.ofNullable(jsonObject.getString("test1")).orElse(""));
        System.out.println(jsonObject.toJSONString());
        //System.out.println(jsonObject.getString("test"));
    }
}
