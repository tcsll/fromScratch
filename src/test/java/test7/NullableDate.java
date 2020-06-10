package test7;

import com.sun.istack.Nullable;
import org.apache.hadoop.mapred.lib.db.DBInputFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.codehaus.jackson.map.ext.JodaSerializers;
import org.codehaus.jackson.map.ser.std.DateSerializer;

import java.util.Date;
import java.util.Optional;

/**
 * @author ：shill
 * @date ：Created in 2020/4/14 18:04
 * @description : Date字段设置空值
 */
public class NullableDate {
    public static void main(String[] args) {
        Date date = null;
     //   Date testDay = Optional.ofNullable(date).orElse(JodaSerializers.DateTimeSerializer.None);

      //  System.out.println(testDay.getTime());

        //取随机数
        //(数据类型)(最小值+Math.random()*(最大值-最小值+1))

        for(int i=0;i<10000;i++) {
            System.out.println((int) (1 + Math.random() * (60 - 1 + 1)));
        }



    }
}
