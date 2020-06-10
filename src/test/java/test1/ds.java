package test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ：shill
 * @date ：Created in 2020/5/21 15:34
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class ds {
    @Value("234")
    int test;
}
