package 大厂笔试题.百度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-28 22:15
 */
//题目描述
//对于一个十进制正整数x，如果x的每一位数字只可能是1，2，3中的其中一个，则称x是完美数。如:123，1，3321 都是完美数，而5,1234则不是。
//
//牛牛想写一个函数f(n)，使得其返回最大的不大于n的完美数，请你帮助牛牛实现这个函数。
//
//输入描述
//第一行一个正整数T表示单组测试数据的组数。接下来T行每行一个正整数n。
//1<T≤10^5
//1<n≤10^18


public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
        int n = in.nextInt();
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            String str = in.next();
            System.out.println(str);
            char[] chars = str.toCharArray();
            int j = 0;
            while (j < chars.length) {
                if (chars[j] > '3') {
                    break;
                } else if (chars[j] == '0') {
                    if (j == 0) {
                        j++;
                        break;
                    }
                    chars[j] = '9';
                    j--;
                    chars[j]--;
                }else{
                    j++;
                }
            }
            for (int k = j; k < chars.length; k++) {
                chars[k] = '3';
//                System.out.println();
            }
            System.out.println(Long.parseLong(new String(chars)));
        }


    }
}
