package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-30 19:24
 */
public class 树中公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }
    private List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        pathTracking(root, target, new ArrayList<Integer>());
        return ret;
    }

    private void pathTracking(TreeNode node, int target, List<Integer> path){
        if(node == null) return;
        path.add(node.val);
        target -= node.val;
        if(target == 0 && node.left == null && node.right == null){
            ret.add(path);
        } else {
            pathTracking(node.left, target, path);
            pathTracking(node.right, target, path);
        }
        path.remove(path.size() - 1);

    }
}
