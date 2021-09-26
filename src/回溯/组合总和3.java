package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和3 {

    private List<List<Integer>> result = new ArrayList<>();
    // 1~9，选k个数，和为n
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int k, int n, int step, int sum, List<Integer> path) {
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum >= n || path.size() >= k || step > 9) {
            return;
        }
        backtrack(k, n, step+1, sum, path);
        path.add(step);
        backtrack(k, n, step+1, sum+step, path);
        path.remove(path.size()-1);
    }
}
