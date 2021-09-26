package 大厂笔试题.虾皮;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Integer result = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        int target = Integer.parseInt(str);
        char[] chars = str.toCharArray();
        int[] visited = new int[n];
        dfs(chars, visited);
        for (String temp : res) {
            int value = Integer.parseInt(temp);
            if (value < target) {
                result = Math.max(result, value);
            }
        }
        System.out.println(result);
    }

    private static List<String> res = new ArrayList<>();
    private static List<Character> path = new ArrayList<>();
    private static void dfs(char[] chars,int[] visited) {
        if (path.size() == chars.length) {
            char[] temp = new char[path.size()];
            for (int i = 0; i < path.size(); i++) {
                temp[i] = path.get(i);
            }
            res.add(String.valueOf(temp));
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == 1 || (i > 0 && chars[i] == chars[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            path.add(chars[i]);
            dfs(chars, visited);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
