package 大厂笔试题.美团;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "-");
        map.put('-', " ");
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            System.out.println(func(str,length,map));

        }
    }


    private static String func(String str, int length,Map<Character, String> map) {
        StringBuilder result = new StringBuilder();
        char[] nums = str.toCharArray();
        char pre = nums[0];
        int step = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == pre) {
                step++;
            }
            if (nums[i] != pre || i == length-1) {
                String content = map.get(pre);
                int index;
                if (step % content.length() == 0) {
                    index = content.length() - 1;
                } else {
                    index = step % content.length() - 1;
                }
                result.append(content.charAt(index));
                step = 1;
                pre = nums[i];
                //处理最后一个
                if (i == length - 1) {
                    String content2 = map.get(pre);
                    if (step % content2.length() == 0) {
                        index = content2.length() - 1;
                    } else {
                        index = step % content2.length() - 1;
                    }
                    result.append(content2.charAt(index));
                }
            }
        }
        return new String(result);
    }

}
