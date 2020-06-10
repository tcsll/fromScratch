package test8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：shill
 * @date ：Created in 2020/4/15 10:18
 * @description : 跟当天的时间对比
 */
public class TimeTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDayFormat= new SimpleDateFormat("yyyy-MM-dd");

        String indentStr="2020-04-15 12:43:12";

        Date indentDate=simpleDayFormat.parse(indentStr);
        System.out.println("indentDate:"+indentDate);



        Date compareDate=new Date();
        compareDate.setDate(indentDate.getDate());
        compareDate.setHours(23);
        compareDate.setMinutes(0);
        compareDate.setSeconds(0);
        System.out.println("compareDate:"+compareDate);

        Date now=new Date();

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatNow=simpleDateFormat.format(now);
        System.out.println("now:"+formatNow);

        if(now.before(compareDate)){
            System.out.println("早");
        }else {
            System.out.println("迟");
        }







    }
}
