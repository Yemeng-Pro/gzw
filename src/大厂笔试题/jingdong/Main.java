package 大厂笔试题.jingdong;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-24 19:45
 */
public class Main {
    private static int gift = 0;
    private static int votes = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n个投票结果
        int m = in.nextInt();//投票范围m
        int[] num = new int[n];
        int[] vote = new int[m + 1];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            vote[num[i]]++;
        }
        for (int i = 0; i < vote.length; i++) {
            if (vote[i] > votes){
                votes = vote[i];
                gift = i;
            }
        }
        System.out.println(gift+" "+votes);
    }
}
