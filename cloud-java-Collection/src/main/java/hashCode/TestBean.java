package hashCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：shill
 * @date ：Created in 2020/7/1 21:30
 * @description : 一个 bean
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestBean {
    private int id;
    private String name;
    private String role;
}
