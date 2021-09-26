package 大厂笔试题.美团4_18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-18 9:54
 */
public class Main2 {
    private static String res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayA = in.nextInt();
        int arrayB = in.nextInt();
        int k = in.nextInt();
        Map<Integer, Integer> mapA = new HashMap<>();//key表示个数,value表示战斗力
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < arrayA; i++) {
            int value = in.nextInt();
            int fight = in.nextInt();
            if (fight >= k) {
                if (mapA.containsKey(fight)) {
                    int tem = value + mapA.get(fight);
                    mapA.put(fight,tem);
                }else{
                    mapA.put(fight, value);
                }

            }

        }
        for (int i = 0; i < arrayB; i++) {
            int fight = in.nextInt();
            int value = in.nextInt();
            if (fight >= k) {
                if (mapB.containsKey(fight)) {
                    int tem = value + mapB.get(fight);
                    mapB.put(fight,tem);
                }else {
                    mapB.put(fight, value);
                }
            }
        }
        int sumofA = 0;
        for (Integer key : mapA.keySet()) {
            int value = mapA.get(key);
            sumofA += value*key;
        }
        int sumofB = 0;
        for (Integer key : mapB.keySet()) {
            int value = mapB.get(key);
            sumofB += value*key;
        }
        if (sumofA > sumofB) {
            res = "A";
        }else{
            res = "B";
        }
        System.out.println(sumofA + " " + sumofB);
        System.out.println(res);

    }
}
