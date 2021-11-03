package 大厂笔试题.携程;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        char[] num = str.toCharArray();
        int times = length / 2;
        int result = 0;
        for (int i = 1; i <= times; i++) {
            int index = 0;
            int size = i * 2; //滑动窗口大小

            LinkedList<Character> list = new LinkedList<>();
            //先入第一个窗口
            for (int j = 0; j < size; j++) {
                list.addLast(num[index++]);
            }
            if (istrue(list)) {
                result++;
            }
            for (int j = size; j < length; j++) {
                list.removeFirst();
                list.addLast(num[index++]);
                if (istrue(list)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }


    private static boolean istrue(LinkedList<Character> list) {
        int nums_T = 0;
        int nums_R = 0;
        int nums_I = 0;
        int nums_P = 0;
        for (Character str : list) {
            if (str == 'T') {
                nums_T++;
            } else if (str == 'R') {
                nums_R++;
            } else if (str == 'I') {
                nums_I++;
            } else if (str == 'P') {
                nums_P++;
            }
        }
        return (nums_T == nums_R) && (nums_I == nums_P);
    }
}
