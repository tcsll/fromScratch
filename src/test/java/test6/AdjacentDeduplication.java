package test6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：shill
 * @date ：Created in 2020/4/13 18:00
 * @description : 相邻去重
 */
public class AdjacentDeduplication {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(9);
        System.out.println(list.toString());

        int flag=list.get(0);
        result.add(flag);
        for(int i=0;i<list.size()-1;i++){
            int compare=list.get(i+1);
            if(compare!=flag){
                result.add(compare);
                flag=compare;
            }
        }
        System.out.println(result.toString());






    }
}
