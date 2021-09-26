package 大厂笔试题.虾皮;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.length() <= 3) {
            System.out.println(input);
        }
        char[] chars = input.toCharArray();

        StringBuilder res = new StringBuilder();
        int j = 0;
        int n = input.length();
        if (n % 3 == 1) {
            res.append(chars[j++]);
            res.append(',');
        } else if (n % 3 == 2) {
            res.append(chars[j++]);
            res.append(chars[j++]);
            res.append(',');
        }
        int m = n/3;
        for (int i = 0; i < m; i++) {
            res.append(chars[j++]);
            res.append(chars[j++]);
            res.append(chars[j++]);
            res.append(',');
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res);

    }
}
