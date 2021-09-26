package 大厂笔试题.百度;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-28 16:58
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int sum = 0;
        if (input.length() == 5) {
            System.out.println("horse");
        } else if (input.length() == 3) {
            if (input.contains("c")) sum++;
            if (input.contains("a")) sum++;
            if (input.contains("t")) sum++;
            if (sum >= 2) {
                System.out.println("cat");
            } else {
                System.out.println("pig");
            }
        }
    }
}
