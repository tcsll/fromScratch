package com.response;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.HashMap;

public class ResponseBo extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    // 成功
    private static final Integer SUCCESS = 20000;
    // 警告
    private static final Integer WARN = 20001;
    // 异常 失败
    private static final Integer FAIL = 40000;
    // 未认证
    private static final Integer UNAUTHORIZED = 51000;
    // 超频
    private static final Integer OVERCLOCKING = 60000;

    public ResponseBo() {
        put("code", SUCCESS);
        put("data", "操作成功");
    }

    public static String error(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", FAIL);
        responseBo.put("data", msg);
        return responseBo.toString();
    }

    public static String warn(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", WARN);
        responseBo.put("data", msg);
        return responseBo.toString();
    }

    public static String ok(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", SUCCESS);
        responseBo.put("data", msg);
        return responseBo.toString();
    }

    public static ResponseBo ojbk(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", SUCCESS);
        responseBo.put("data", msg);
        return responseBo;
    }

    public static String unAuthorized(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", UNAUTHORIZED);
        responseBo.put("data", msg);
        return responseBo.toString();
    }

    public static String overClocking(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", OVERCLOCKING);
        responseBo.put("data", msg);
        return responseBo.toString();
    }

    public static String ok() {
        return new ResponseBo().toString();
    }

    public static String error() {
        return ResponseBo.error("");
    }

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        JSONObject obj = (JSONObject) JSONObject.toJSON(this);
        String str = JSONObject.toJSONString(obj, filter);
        System.out.println(str);
        return str;
    }

    private ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null) {
                return "";
            }
            return v;
        }
    };
}
