package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-11 21:14
 */
public class Test {
    public static void main(String[] args) {

    }

    List<String> res = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    char[] str;

    public String[] permutation(String s) {
        int n = s.length();
        int[] visited = new int[n];
        str = s.toCharArray();
        dfs(visited);
        return res.toArray(new String[0]);

    }

    private void dfs(int[] visited) {
//        if (temp.length() == str.length) {
            res.add(temp.toString());
//        }

        for (int i = 0; i < str.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            temp.append(str[i]);
            dfs(visited);
            visited[i] = 0;
            temp.deleteCharAt(temp.length()-1);
        }
    }

    @org.junit.Test
    public void test222() {
        String s = "abc";
        String[] a = permutation(s);
        for (String b : a) {
            System.out.println(b);
        }

    }
}
