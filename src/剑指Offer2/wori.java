package 剑指Offer2;

import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2021-05-29 17:17
 */
public class wori {
    public static void main(String[] args) {

        Integer a = 1;
        test(a);
//        Boolean t = true;
//        test(t);
//        int c = 1;
//        test(c);
        ArrayList<Integer> ans = new ArrayList<>();
        Integer[] ts = ans.toArray(new Integer[0]);
        int[] res = new int[ts.length];
        for (int i = 0; i < ts.length; i++) {
            res[i] = ts[i];
        }

    }

    private static void test(Object o) {
        System.out.println(o+"+object");
    }

    private static void test(int a) {
        System.out.println(a+"+int");
    }
    private static void test(Integer a) {
        System.out.println(a+"+Integer");
    }
}
