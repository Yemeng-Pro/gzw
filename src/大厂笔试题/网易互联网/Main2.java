package 大厂笔试题.网易互联网;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String result = Integer.toBinaryString(num);
        char[] binary = result.toCharArray();
        System.out.println(func(binary));
    }

    private static int func(char[] binary) {
        int result = 0;
        int i = 0;
        int length = binary.length;
        //特殊情况考虑，只有一个0的时候
        for (char c : binary) {
            int count0 = 0;
            if (c == '0') {
                count0++;
            }
            if (count0 == 1) {
                return 3;
            }
        }
        //一般情况
        while (i < length) {
            if (binary[i] == '1') {
                int count = 1;
                while (i+1 < length && binary[i + 1] == '1') {
                    i++;
                    count++;
                }
                if (count >= 2) {
                    result += 2;
                } else {
                    result += 1;
                }
                i++;
            }else{
                i++;
            }
        }
        return result;
    }


}
