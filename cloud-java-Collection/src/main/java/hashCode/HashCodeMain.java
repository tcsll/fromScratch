package hashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：shill
 * @date ：Created in 2020/7/1 21:38
 * @description :
 */
public class HashCodeMain {
    public static void main(String[] args) {


        /*无重写*/
        TestBean testBean1 =new TestBean(1,"sll","tc");
        TestBean testBean2=new TestBean(2,"sll","wd");

        System.out.println(testBean1.hashCode());
        System.out.println(testBean2.hashCode());

        System.out.println(testBean1.equals(testBean2));
        System.out.println(testBean1 ==testBean2);


        /*有重写*/
        OverwriteTestBean overwriteTestBean1 =new OverwriteTestBean(1,"sll","tc");
        OverwriteTestBean overwriteTestBean2=new OverwriteTestBean(2,"sll","wd");

        System.out.println(overwriteTestBean1.equals(overwriteTestBean2));
        System.out.println(overwriteTestBean1 == overwriteTestBean2);

        System.out.println(overwriteTestBean1.hashCode());
        System.out.println(overwriteTestBean2.hashCode());

        //判断hashCode对集合类操作的影响
        Set<Object> set=new HashSet<>();
        set.add(overwriteTestBean1);
        set.add(overwriteTestBean2);
        System.out.println(set);





    }
}
