package 二叉树.路径和;

import 剑指Offer2.Solution;

import java.util.ArrayList;
import java.util.List;

public class 路径总和3 {
    //不一定从根到叶
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, new ArrayList<Integer>(), sum);
        return count;
    }
    //回溯
    private void dfs(TreeNode root, List<Integer> path, int sum) {
        if (root == null) return;
        path.add(root.val);
        int curSum = 0;
        for (int i = path.size()-1; i >= 0; --i) {
            curSum += path.get(i);
            if (curSum == sum) count++;
        }
        dfs(root.left, path, sum);
        dfs(root.right, path, sum);
        path.remove(path.size()-1);
    }



    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}
