package leetcode;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-08 15:38
 */
public class 华为机试第一题 {

    private static Map<String ,String> pre = new HashMap<>();
    private static Map<String ,Integer> rank = new HashMap<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//获取
        //初始化的同时进行聚合操作
        for (int i = 0; i < n; i++) {
            String s1 = input.next();
            String s2 = input.next();
            rank.put(s1,1);
            rank.put(s2,1);
//            pre.put(s1,s1);
//            pre.put(s1,s2);
//            pre.put(s1,s2);
            union(s1,s2);
        }

        Collection<String> values = pre.values();
        Set<String> set = new HashSet<>(values);
        System.out.println(set.size());
    }

    private static String find(String str1){
        if(pre.get(str1) == null)
        {
            pre.put(str1,str1);
            return str1;
        }
        if(!str1.equals(pre.get(str1))){
            String temp = find(pre.get(str1));
            pre.put(str1,temp);
        }
        return pre.get(str1);
//        if(str1.equals(pre.get(str1))) return str1;
//        pre.put(str1,find(pre.get(str1)));
//        return pre.get(str1);
    }

    private static void union(String s1,String s2) {
        String f1 = find(s1);
        String f2 = find(s2);
        if (f1.equals(f2)){
            return;
        }
        if (rank.get(f1) >= rank.get(f2)) {
            pre.put(f2, f1);
            int newRank = rank.get(f1) + rank.get(f2);
            rank.put(f1,newRank);
        } else {
            pre.put(f1, f2);
            int newRank = rank.get(f1) + rank.get(f2);
            rank.put(f2,newRank);
        }

    }
}
