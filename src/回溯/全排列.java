package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    @Test
    public void test() {
        int[] array = {1, 2, 3};
        permute(array);
        System.out.println(result);

    }



    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path);
        return result;
    }
    // 路径：记录在path中
    // 决策阶段：k
    // 可选列表：nums中除掉存在于path中的数据
    private void backtrack(int[] nums, int k, List<Integer> path) {
    // 结束条件
        if (k == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (path.contains(nums[i])) {
                continue;
            }
            // 做选择
            path.add(nums[i]);
//            System.out.println("1"+path.toString());
            // 递归
            backtrack(nums, k+1, path);
//            System.out.println("2"+path.toString());
            // 撤销选择
            path.remove(new Integer(nums[i]));
//            System.out.println("3"+path.toString());
        }
    }
}
