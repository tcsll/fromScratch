package test9;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：shill
 * @date ：Created in 2020/4/16 9:38
 * @description :
 */
public class Main {


    public String genPrintStr() {

        String departureStation = "福州市台江区";
        String destination = "福州市鼓楼区";
        String stationName = "周杨物流";
        String senderName = "大佬";
        String senderPhone = "18050225333";
        String receiverName = "效劳";
        String receiverPhone = "18030442334";
        String senderCity = "福建省福州市台江区";
        String senderAddress = "申发大厦23A";
        String receiverCity = "福建省福州市鼓楼区";
        String receiverAddress = "金山科技孵化园";
        String goodsName = "茶叶";
        String quantity = "2件";
        String weight = "12kg";
        String pickupWay = "自提";
        String totalFreight = "123元";
        String insure = "12元";
        String collectCharge = "43元";
        String receipt = "有";
        String notes = "贵重物品，轻拿轻放";


        //29-30个汉字
        StringBuilder printContentBuilder = new StringBuilder();
        String splitStr = "**********************************************\n";

        String width = "<PW>080</PW>\n";
        printContentBuilder.append(width);
        printContentBuilder.append("<QR>https://www.fzyjftech.com/logistics/mobile/receive/receive?id=88100013800</QR>").append("\n");
        printContentBuilder.append(splitStr);
        //始发站-目的地-第18位分割
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("始发站：").append(departureStation);
        lineBuilder= Main.fill(lineBuilder);
        lineBuilder.append("目的地：").append(destination).append("\n");
        lineBuilder.append(splitStr);
        printContentBuilder.append(lineBuilder);

        //揽件物流
        lineBuilder = new StringBuilder();
        lineBuilder.append("揽件物流：").append(stationName).append("\n");
        printContentBuilder.append(lineBuilder);
        printContentBuilder.append(splitStr);

        //寄件人-收件人
        lineBuilder = new StringBuilder();
        lineBuilder.append("收件：");
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append("寄件：").append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append(senderName).append(" ").append(senderPhone);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append(receiverName).append(" ").append(receiverPhone).append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append(senderCity);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append(receiverCity).append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append(senderAddress);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append(receiverAddress).append("\n");
        lineBuilder.append(splitStr);
        printContentBuilder.append(lineBuilder);


        lineBuilder = new StringBuilder();
        lineBuilder.append("物品名称：").append(goodsName);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append("总运费：").append(totalFreight).append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append("件数：").append(quantity);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append("货保价值：").append(insure).append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append("重量：").append(weight);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append("代收货款：").append(collectCharge).append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append("取件方式：").append(pickupWay);
        lineBuilder = Main.fill(lineBuilder);
        lineBuilder.append("回单：").append(receipt).append("\n");
        printContentBuilder.append(lineBuilder);

        lineBuilder = new StringBuilder();
        lineBuilder.append(splitStr);
        lineBuilder.append("备注信息").append("\n");
        lineBuilder.append(notes);
        printContentBuilder.append(lineBuilder);

        return printContentBuilder.toString();


    }


    private static StringBuilder fill(StringBuilder sb) {
        System.out.println(sb.length());
        if (sb.length() < 17) {
            int fill = 18 - sb.length();
            for (int i = 0; i < fill; i++) {
                sb.append(" ");
            }
        }
        return sb;
    }


    public static void main(String[] args) {


        // Methods.getInstance().init("1061006793","717eeb8598b6094d1959d4a124b65c5d");
        // System.out.println("line1:"+Methods.getInstance().getFreedomToken());
        // System.out.println("line2:"+ Methods.getInstance().refreshToken());
        // String str =
        //         "<PW>080</PW>\n" +
        //                 "<QR>ds</QR>\n" +
        //                 "**********************************************\n" +
        //                 "始发站：福州市台江区        终点站：福州市鼓楼区\n" +
        //                 "**********************************************\n" +
        //                 "揽件物流：周杨物流             【托运单】\n" +
        //                 "**********************************************\n" +
        //                 "寄件:                      收件：\n" +
        //                 "大佬 18050223444           小捞 18345633433\n" +
        //                 "福建省福州市台江区         福建省福州市鼓楼区\n" +
        //                 "曙光路申发大厦             金山科技孵化器\n" +
        //                 "**********************************************\n" +
        //                 "品名：西瓜                 总运费：1334元\n" +
        //                 "件数：23件                 货保价值：34元\n" +
        //                 "重量：23kg                 代收货款：33元\n" +
        //                 "取件：自提                 回单：否\n" +
        //                 "**********************************************\n" +
        //                 "备注：\n" +
        //                 "贵重物品，轻拿轻放\n";
        //
        //
        //
        //
        Main main = new Main();
        Map<String, String> param = new HashMap<>(8);
        param.put("client_id", "1061006793");
        param.put("access_token", "f385dbc7fecf467989596d4c312545c9");
        param.put("machine_code", "4004661497");
        param.put("origin_id", "2");
        param.put("id", LAVApi.getuuid());
        param.put("sign", LAVApi.getSin(String.valueOf(System.currentTimeMillis() / 1000)));
        param.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        param.put("content", main.genPrintStr());


        System.out.println(Request.sendPost("https://open-api.10ss.net/print/index", param));


    }
}
