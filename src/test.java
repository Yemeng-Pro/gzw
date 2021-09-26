import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yemeng
 * @create 2021-02-18-20:44
 */
public class test {
    static List<StringBuilder> res = new ArrayList<>();
    static StringBuilder temp = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int k = in.nextInt();
        boolean[] visited = new boolean[n + 1];
        dfs(n, visited);
        StringBuilder result = res.get(k - 1);
        System.out.println(result);
    }
    public static void dfs(int n, boolean[] visited) {
        if (temp.length() == n) {
            res.add(new StringBuilder(temp));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            temp.append(i);
            dfs(n, visited);
            visited[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }

    }


}
