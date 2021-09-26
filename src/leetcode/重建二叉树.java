package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-03-25 10:13
 */

public class 重建二叉树 {
   //中序数组用于确认左子树和右子树的位置
   //前序用于重建二叉树
   private Map<Integer,Integer> indexForInOrders = new HashMap<>();
   public TreeNode reCons(int[] pre, int[] in){
      for (int i = 0; i < in.length; i++) {
         indexForInOrders.put(in[i],i);
      }
      return reCons(pre,0,pre.length-1,0);
   }

   private TreeNode reCons(int[] pre, int preL, int preR, int intL) {
      if (preL > preR){
         return null;
      }
      TreeNode root = new TreeNode(pre[preL]);
      int inIndex = indexForInOrders.get(root.val);
      int leftTreeSize = inIndex - intL;
      root.left = reCons(pre,preL+1,preL + leftTreeSize,intL);
      root.right = reCons(pre, preL + 1 + leftTreeSize, preR, intL + leftTreeSize + 1);
      return root;
   }




}






