package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 组合总和2 {
    //数组有重复，且只能用一次
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        // HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if(i>start&&candidates[i]==candidates[i-1])
            {
                continue;
            }
            // set.add(candidates[i]);
            temp.add(candidates[i]);
            dfs(candidates, i+1, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }


//    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int count = 1;
            if (hm.containsKey(nums[i])) {
                count += hm.get(nums[i]);
            }
            hm.put(nums[i], count);
        }
        int n = hm.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (hm.containsKey(nums[i])) {
                uniqueNums[k] = nums[i];
                counts[k] = hm.get(nums[i]);
                k++;
                hm.remove(nums[i]);
            }
        }
        backtrack(uniqueNums, counts, 0, new ArrayList<Integer>());
        return result;
    }
    private void backtrack(int[] uniqueNums, int[] counts, int k, List<Integer> path) {
        if (k == uniqueNums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int count = 0; count <= counts[k]; ++count) {
            for (int i = 0; i < count; ++i) {
                path.add(uniqueNums[k]);
            }
            backtrack(uniqueNums, counts, k+1, path);
            for (int i = 0; i < count; ++i) {
                path.remove(path.size()-1);
            }
        }
    }
}
