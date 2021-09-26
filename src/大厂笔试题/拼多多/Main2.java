package 大厂笔试题.拼多多;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = in.nextInt();
        int[] books = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            books[i] = in.nextInt();
            sum += books[i];
        }
        int[] books2 = new int[sum];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < books[i]; j++) {
                books2[temp + j] = i + 1;
            }
            temp += books[i];
        }
        int m = in.nextInt();
//        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            list.add(books2[in.nextInt() - 1]);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(list.get(i));
        }
    }
}
