package 大厂笔试题.百度;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-28 17:08
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (pig(input)) {
            System.out.println("pig");
        } else if (horse(input)) {
            System.out.println("horse");
        } else if (cat(input)) {
            System.out.println("cat");
        }

    }

    public static boolean pig(String str) {
        int k = 0;
        String name = "pig";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == name.charAt(i)) {
                k++;
            }
        }
        if (k >= str.length() - 1) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean cat(String str) {
        int k = 0;
        String name = "cat";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == name.charAt(i)) {
                k++;
            }
        }
        if (k >= str.length() - 1) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean horse(String str) {
        int k = 0;
        String name = "horse";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == name.charAt(i)) {
                k++;
            }
        }
        if (k >= str.length() - 1) {
            return true;
        } else {
            return false;
        }
    }
}
