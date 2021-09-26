package 大厂笔试题.阿里笔试;

import java.lang.reflect.Array;
import java.util.*;


public class Main5 {
    //三人打牌，每个人都有n张牌，每次每个人都出一张牌，留下最小的一张，n次操作之后，最小的牌的和最小是多少
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Queue<Integer>> cardList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Queue<Integer> card = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                card.add(sc.nextInt());
            }
            cardList.add(card);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Integer a = cardList.get(0).peek();
            Integer b = cardList.get(1).peek();
            Integer c = cardList.get(2).peek();
            int min = Math.min(a, Math.min(b, c));
            if (a == min) {
                sum += cardList.get(0).poll();
            } else if (b == min) {
                sum += cardList.get(1).poll();
            } else {
                sum += cardList.get(2).poll();
            }
        }
        System.out.println(sum);
    }
}
