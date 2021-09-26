package 大厂笔试题.滴滴;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0'){
                nums[i] = 0;
            } else if (chars[i] == '1') {
                nums[i] = 1;
            } else if (chars[i] == '2') {
                nums[i] = 2;
            } else {
                nums[i] = 3;
            }
        }
        int result = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                stack1.add(0);
            }
            if (nums[i] == 2) {
                stack2.add(2);
            }
            if (nums[i] == 1) {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                    result++;
                }
            }
            if (nums[i] == 3) {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                    result++;
                }
            }
        }
        System.out.println(result*2);
    }
}
