package 二叉树.路径和;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {
    //从跟到叶
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target,new ArrayList<Integer>());
        return result;
    }

    private void dfs(TreeNode root,int target,List<Integer> path) {
        if (root == null) {
            return;
        }
        target -= root.val;
        path.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);
        path.remove(path.size() - 1);
    }


}
