package 大厂笔试题.腾讯;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int result = func(num);
            System.out.println(result);
        }
    }

    private static int func(int num) {
        int one = 1;
        int two = 1 + num;
        while (!isPrimeNumber(two)) {
            two++;
        }
        int three = two + num;
        while (!isPrimeNumber(three)) {
            three++;
        }
        int four = two*three;
        return four;
    }

    private static boolean isPrimeNumber(int num){
        if (num == 2) {
            return true;
        }
        if (num < 2 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
