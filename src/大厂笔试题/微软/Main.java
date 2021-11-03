package 大厂笔试题.微软;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static int result = 0;
    public int solution(String[] A) {
        // write your code in Java SE 8
        List<String> path = new ArrayList<>();
        dfs(A, 0, path);
        return result;
    }
    private void dfs(String[] A, int index, List<String> path) {
        if (index == A.length) {
            result = Math.max(result, length(path));
            return;
        }
        path.add(A[index]);
        dfs(A, index + 1, path);
        path.remove(path.size() - 1);
        dfs(A, index + 1, path);
    }
    private int length(List<String> path){
        StringBuilder A = new StringBuilder();
        for (String s : path) {
            A.append(s);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (map.containsKey(c)) {
                return -1;
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return A.length();
    }
}
