package 大厂笔试题.百度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-28 15:40
 */
public class Main2 {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.next();
        }
        for (int i = 0; i < n; i++) {
            String temp = input[i];
            String[] son = new String[temp.length() / 3];
            for (int j = 0; j < temp.length(); j+=3) {
                Arrays.fill(son, temp.substring(j, j + 3));
            }
            boolean t = compare(son);
            if (t) {
                res.add("Yes");
            } else {
                res.add("No");
            }
        }
        for (String result : res) {
            System.out.println(result);
        }


    }
    public static boolean compare(String[] son){
        for (int i = 0; i < son.length; i++) {
            for (int j = i; j < son.length; j++) {
                int res = compare2(son[i].toCharArray(), son[j].toCharArray());
                if (res >= 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int compare2(char[] word,char[] input){
        int num = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] != input[i]) {
                num++;
            }
        }
        return num;
    }

}
