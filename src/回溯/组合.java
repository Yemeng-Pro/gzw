package 回溯;

import org.junit.Test;

import java.util.*;

public class 组合 {
    @Test
    public void test() {
        int n = 3;
        int k = 2;
        System.out.println(combine(3, 2).toString());
//        System.out.println(res.toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path ,res);
        return res;
    }

    private void dfs(int n, int k, int cur, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));   //传递的是地址的拷贝！！！！！！！！得new一个list
            System.out.println(res.toString());
            return;
        }
        for (int i = cur; i <=n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path,res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

//    private List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> combine(int n, int k) {
//        backtrack(n, k, 1, new ArrayList<Integer>());
//        return result;
//    }
//    // n,k必须的参数
//// step阶段
//// path路径
//// step选与不选-可选列表
//    private void backtrack(int n, int k, int step, List<Integer> path) {
//        if (path.size() == k) {
//            result.add(new ArrayList(path));
//            return;
//        }
//        if (step == n + 1) {
//            return;
//        }
//        backtrack(n, k, step + 1, path);
//        path.add(step);
//        backtrack(n, k, step + 1, path);
//        path.remove(path.size() - 1);
//    }

}
