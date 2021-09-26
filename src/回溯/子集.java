package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }
    // k阶段
    // path路径
    // nums[k]选或不选-可选列表
    private void backtrack(int[] nums, int k, List<Integer> path) {
        if (k == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        backtrack(nums, k+1, path);
        path.add(nums[k]);
        backtrack(nums, k+1, path);
        path.remove(path.size()-1);
    }
}
