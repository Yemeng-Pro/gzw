package 二叉树.反向构建二叉树;

public class 判断是否是二叉搜索树的后续遍历 {
    private boolean valid = true;
    public boolean verifyPostorder(int[] postorder) {
        myVerify(postorder, 0, postorder.length-1);
        return valid;
    }
    private void myVerify(int[] postorder, int i, int j) {
        if (!valid) return; //提前退出条件
        if (i >= j) return;
        // postorder[j]是根节点,先分离出左⼦树[i, k-1]
        int k = i;
        while (k < j && postorder[k] < postorder[j]) {
            k++;
        }
        // 验证[k, j-1]满⾜有⼦树的要求，都⼤于postorder[j]
        int p = k;
        while (p < j) {
            if (postorder[p] < postorder[j]) {
                valid = false;
                return;
            }
            p++;
        }
        // 递归验证左右⼦树是否满⾜BST的要求
        myVerify(postorder, i, k-1);
        myVerify(postorder, k, j-1);
    }
}
