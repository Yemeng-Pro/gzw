package 大厂笔试题.网易互联网;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        int num2 = Integer.parseInt(num);
        char[] nums = num.toCharArray();
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            char temp = nums[i];
            int a = temp - '0';
            if (a == 0) {
                continue;
            } else if (num2 % a == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
