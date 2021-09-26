package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和1 {
    //无重复，瞎几把用
    @Test
    public void test() {
        int[] array = {1,2};
        int target = 3;
        combinationSum(array, target);
        System.out.println(result.toString());
    }

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return result;
    }

    private void dfs(int[] candidates, int start, int target) {
        if (target == 0) {
            // if (!temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
            // }
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, i, target - candidates[i]);  //不可重复就i+1
            temp.remove(temp.size() - 1);
        }
    }

//
//    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int k, int left, List<Integer> path) {
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (k == candidates.length) {
            return;
        }
        for (int i = 0; i <= left/candidates[k]; ++i) {
            for (int j = 0; j < i; ++j) {
                path.add(candidates[k]);
            }
            backtrack(candidates, k+1, left-i*candidates[k], path);
            for (int j = 0; j < i; ++j) {
                path.remove(path.size()-1);
            }
        }
    }
}
