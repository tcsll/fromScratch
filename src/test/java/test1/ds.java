package test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.beans.factory.annotation.Value;

import java.text.NumberFormat;

/**
 * @author ：shill
 * @date ：Created in 2020/5/21 15:34
 * @description :
 */

public class ds {
    public static void main(String[] args) {
        //回单比例
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float)32.33/(float)4343.34*100);
        System.out.println(result);
    }

}
