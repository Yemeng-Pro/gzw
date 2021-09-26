package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-30 10:50
 */
public class 数组中只出现一次的数字 {
    public int[] singleNumbers(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < array.length; i++){
            if(map.containsKey(array[i]))
                map.put(array[i],2);
            else
                map.put(array[i],1);
        }


        List<Integer> temp = new ArrayList();

        for(int i = 0; i<array.length;i++){
            if(map.get(array[i])==1){
                temp.add(array[i]);
            }
        }

        int[] res = new int[temp.size()];
        int count = 0;
        for(Integer num : temp){
            res[count++] = num;

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(1%1);
        Integer a = Integer.MAX_VALUE;
    }
}
