package 动态规划.其他;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 路径总和 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(pathSum(root,5));

    }


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

//    //dp
//    private int count = 0;
//    public int pathSum(TreeNode root, int sum) {
//        dfs(root, sum);
//        return count;
//    }
//    // 返回以root为上端点的路径的所有可能的⻓度（key）对应的路径的个数（value）
    private Map<Integer, Integer> dfs(TreeNode root, int sum) {
        if (root == null) return new HashMap<>();
        Map<Integer, Integer> leftValues = dfs(root.left, sum);
        Map<Integer, Integer> rightValues = dfs(root.right, sum);
        Map<Integer, Integer> rootValues = new HashMap<>();
        rootValues.put(root.val, 1);
        for (Map.Entry<Integer, Integer> entry : leftValues.entrySet()) {
            int newKey = entry.getKey()+root.val;
            int newValue = entry.getValue();
            if (rootValues.containsKey(newKey)) {
                newValue += rootValues.get(newKey);
            }
            rootValues.put(newKey, newValue);
        }
        for (Map.Entry<Integer, Integer> entry : rightValues.entrySet()) {
            int newKey = entry.getKey() + root.val;
            int newValue = entry.getValue();
            if (rootValues.containsKey(newKey)) {
                newValue += rootValues.get(newKey);
            }
            rootValues.put(newKey, newValue);
        }
        for (Map.Entry<Integer, Integer> entry : rootValues.entrySet()) {
            if (entry.getKey() == sum) {
                count += entry.getValue();
            }
        }
        return rootValues;
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
