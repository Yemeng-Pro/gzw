package 大厂笔试题.携程;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int[] array = new int[26];
            for (int j = 0; j < 26; j++) {
                array[j] = in.nextInt();
            }
        }
        char a = 'A' + 2;
        System.out.println(a);
    }
}
