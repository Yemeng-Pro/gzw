package 大厂笔试题.华为笔试;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-04-14 19:37
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] arr = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if ('(' == arr[i]) {
                stack.push(i);
            } else if (')' == arr[i]) {
                reverse(arr, stack.pop() + 1, i - 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if ('(' != arr[i] && ')' != arr[i]) {
                res.append(arr[i]);
            }
        }
        System.out.println(res.toString());



    }

    private static void reverse(char[] str, int i, int j) {
        while (i < j) {
            swap(str, i, j);
            j--;
            i++;
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
