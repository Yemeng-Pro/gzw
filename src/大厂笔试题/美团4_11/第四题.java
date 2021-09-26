package 大厂笔试题.美团4_11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-12 19:05
 */
public class 第四题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        for (int i = 0; i < str.length(); i++) {

        }
    }

    private static boolean isGJ(char[] a) {
        if (a.length <= 1) {
            return true;
        }
        if (a.length == 2){
            return a[0] == a[1];
        }
        int len = a.length/2;
        Arrays.sort(a);
        if (a[len] == a[len - 1] && a[len] == a[len + 1]) {
            return true;
        }
        return false;
    }
}
