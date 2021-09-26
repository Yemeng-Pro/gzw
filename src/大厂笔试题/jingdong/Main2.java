package 大厂笔试题.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-24 20:01
 */
public class Main2 {
    private static int res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //n=1,有一种放法
        //n=2,有两种放法
        List<Integer> num = new ArrayList<>();

        num.add(0);
        boolean[] visited = new boolean[n];
        dfs(n,num,visited);
        System.out.println(res%998244353);
    }
    private static void dfs(int n,List<Integer> temp,boolean[] visited){
        if (temp.size()== n && n - temp.get(temp.size() -1) <=2) {
            res++;
            return;
        }
        for (int i = 1; i < n; i++) {
            int a = temp.get(temp.size() - 1);
            if (visited[i] || Math.abs(a - i) > 2) {
                continue;
            }
            visited[i] = true;
            temp.add(i);
            dfs(n,temp,visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
