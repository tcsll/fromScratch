package test9;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ：shill
 * @date ：Created in 2020/4/16 10:42
 * @description :
 */
public class JSONStr {

   public  static  String   JSONSTR=
           "{\n" +
                   "  \"OrderCode\": \"0126578665784971\",\n" +
                   "  \"ShipperCode\": \"EMS\",\n" +
                   "  \"PayType\": 1,\n" +
                   "  \"MonthCode\": \"1234567890\",\n" +
                   "  \"ExpType\": 1,\n" +
                   "  \"Cost\": 1.0,\n" +
                   "  \"OtherCost\": 1.0,\n" +
                   "  \"Sender\": {\n" +
                   "    \"Company\": \"LV\",\n" +
                   "    \"Name\": \"Taylor\",\n" +
                   "    \"Mobile\": \"15018442396\",\n" +
                   "    \"PostCode\": \"200000\",\n" +
                   "    \"ProvinceName\": \"上海\",\n" +
                   "    \"CityName\": \"上海市\",\n" +
                   "    \"ExpAreaName\": \"青浦区\",\n" +
                   "    \"Address\": \"明珠路\"\n" +
                   "  },\n" +
                   "  \"Receiver\": {\n" +
                   "    \"Company\": \"GCCUI\",\n" +
                   "    \"Name\": \"收件人啊\",\n" +
                   "    \"Mobile\": \"15018442396\",\n" +
                   "    \"PostCode\": \"350000\",\n" +
                   "    \"ProvinceName\": \"福建省\",\n" +
                   "    \"CityName\": \"福州市\",\n" +
                   "    \"ExpAreaName\": \"台江区\",\n" +
                   "    \"Address\": \"申发大厦\"\n" +
                   "  },\n" +
                   "  \"Commodity\": [\n" +
                   "    {\n" +
                   "      \"GoodsName\": \"鞋子\",\n" +
                   "      \"GoodsQuantity\": 1,\n" +
                   "      \"GoodsWeight\": 1.0\n" +
                   "    },\n" +
                   "    {\n" +
                   "      \"GoodsName\": \"衣服\",\n" +
                   "      \"GoodsQuantity\": 1,\n" +
                   "      \"GoodsWeight\": 1.0\n" +
                   "    }\n" +
                   "  ],\n" +
                   "  \"AddService\": [\n" +
                   "    {\n" +
                   "      \"Name\": \" INSURE \",\n" +
                   "      \"Value\": \"1000\"\n" +
                   "    },\n" +
                   "    {\n" +
                   "      \"Name\": \"COD\",\n" +
                   "      \"Value\": \"1020\",\n" +
                   "      \"CustomerID \": \"1234567890\"\n" +
                   "    }\n" +
                   "  ],\n" +
                   "  \"Weight\": 1.0,\n" +
                   "  \"Quantity\": 1,\n" +
                   "  \"Volume\": 0.0,\n" +
                   "  \"Remark\": \"小心轻放\"\n" +
                   "}";

    public static void main(String[] args) {
        JSONObject jsonObject= JSON.parseObject(JSONStr.JSONSTR);
        System.out.println(jsonObject.toJSONString());

    }




}
