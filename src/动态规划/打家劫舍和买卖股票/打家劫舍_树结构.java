package 动态规划.打家劫舍和买卖股票;



public class 打家劫舍_树结构 {
    //树形DP基于树这种数据结构上做状态推导，⼀般都是从下往上推，⼦节点状态推导⽗节点状态。⼀般都是
    //基于后序遍历来实现。
    class Solution {
        public int rob(TreeNode root) {
            int[] money = postorder(root);
            return Math.max(money[0], money[1]);
        }

        private int[] postorder(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] leftMoney = postorder(root.left);
            int[] rightMoney = postorder(root.right);
            int[] money = new int[2];money[0] = Math.max(leftMoney[0], leftMoney[1]) + Math.max(rightMoney[0], rightMoney[1]);
            money[1] = (leftMoney[0] + rightMoney[0]) + root.val;
            return money;
        }
    }


}

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;
}
