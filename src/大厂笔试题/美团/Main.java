package 大厂笔试题.美团;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
//    static char[] c;
//    static boolean result = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            System.out.println(isBeatiful(str));
//            result = false;
        }
    }

//    public static String isBeatiful(String str) {
//        c = str.toCharArray();
////        dfs(0);
//        if (!result) {
//            return "NO";
//        } else {
//            return "YES";
//        }
//    }

    public static String isBeatiful(String string) {
        char[] chars = string.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        if (map.size() == 1) {
            return "NO";
        } else {
            return "YES";
        }
    }

//    public static void dfs(int x) {
//        if (result) {
//            return;
//        }
//        if (x == c.length - 1) {
//            String temp = new String(c);
//            if (!isPalindrome(temp)) {
//                result = true;
//            }
//        }
//        HashSet<Character> set = new HashSet<>();
//        for (int i = x; i < c.length; i++) {
//            if (set.contains(c[i])) {
//                continue;
//            }
//            set.add(c[i]);
//            swap(i, x);
//            dfs(x + 1);
//            swap(i, x);
//        }
//    }
//
//    private static void swap(int a, int b) {
//        char temp = c[a];
//        c[a] = c[b];
//        c[b] = temp;
//    }
//
//
//    public static boolean isPalindrome(String s){
//        Stack<Character> stack=new Stack<>();
//        StringBuilder str=new StringBuilder(s.length());
//        for(char s2:s.toLowerCase().toCharArray()){
//            if ((s2 >= '0' && s2 <= '9') || (s2 >= 'a' && s2 <= 'z')) {
//                str.append(s2);
//                stack.push(s2);
//            }
//        }
//        for(char s2: str.toString().toCharArray()){
//            if (s2!=stack.pop())
//                return false;
//        }
//        return true;
//    }
}
