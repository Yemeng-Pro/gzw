package 大厂笔试题.网易;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            String str = num + "";
            char[] charnums = str.toCharArray();
            String temp = binary(charnums);
            StringBuilder num2str = new StringBuilder(temp);
            //翻转
            num2str.reverse();
//            System.out.println(num2str);
            //去0
            String temp2 = new String(num2str);
            String temp3 = delet0(temp2);
//            System.out.println(temp3);
            //去重
            char[] chars = temp3.toCharArray();
            String result = func(chars);
            System.out.println(result);
        }
    }

    private static String delet0(String str) {
        char[] chars = str.toCharArray();
        StringBuilder temp = new StringBuilder();
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                p++;
            } else {
                break;
            }
        }
        for (int i = p; i < chars.length; i++) {
            temp.append(chars[i]);
        }
        return new String(temp);
    }

    private static String binary(char[] charnums) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < charnums.length; i++) {
            String temp = Integer.toBinaryString(charnums[i] - '0');
            str.append(temp);
        }
        return new String(str);
    }


    private static String func(char[] chars) {
        StringBuilder a = new StringBuilder();
        Character last = chars[0];
        a.append(last);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == last) {
                continue;
            } else {
                last = chars[i];
                a.append(last);
            }
        }
        return new String(a);
    }


}
