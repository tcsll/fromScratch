package hashCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author ：shill
 * @date ：Created in 2020/7/1 21:30
 * @description : 一个 bean
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OverwriteTestBean {
    private int id;
    private String name;
    private String role;


    @Override
    public boolean equals(Object o){
       if(o==null || getClass() != o.getClass()){
           return false;
       }

       OverwriteTestBean overwriteTestBean = (OverwriteTestBean) o;
        return name.equals((overwriteTestBean).getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }




}
