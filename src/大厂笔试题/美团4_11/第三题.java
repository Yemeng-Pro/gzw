package 大厂笔试题.美团4_11;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-12 19:05
 */
public class 第三题 {
    /**
     * 大致思路如下：分别尽可能地删除0和1来统计0与1的最大差值、以及1与0的最大插值
     * 首先计算0与1的最大差：遇到3个连续的1，直接将这三个连续的1删除；其次，若连续三个数里出现了两个1，也将这三个数删除；这样保证0尽可能地多，1尽可能地少
     * 然后计算1与0的最大差；与上述类似；
     *
     */
    public static void main(String[] args) {
        //读取数据
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String temp = in.nextLine();
        StringBuilder str = new StringBuilder(temp);
        StringBuilder str2 = new StringBuilder(temp);
        int res1 = delete(str, '0', n);
        int res2 = delete(str2, '1', n);
        System.out.println(Math.max(res1,res2));
    }

    private static int delete(StringBuilder str, char temp,int n){
        for (int j = 0; j < n - 2; j++) {
            if (str.charAt(j) == temp && str.charAt(j + 1) == temp && str.charAt(j + 2) == temp) {
                str.delete(j,j+3);
                j--;
                n -= 3;
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (str.charAt(i) == temp && str.charAt(i + 1) == temp
                    || str.charAt(i) == temp && str.charAt(i + 2) == temp
                    || str.charAt(i + 1) == temp && str.charAt(i + 2) == temp) {
                str.delete(i,i+3);
                i--;
                n -= 3;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == temp) {
                res++;
            } else {
                res--;
            }
        }
        return Math.abs(res);
    }

}
