package 大厂笔试题.腾讯;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2 {
    public TreeNode cyclicShiftTree (TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> pre = new LinkedList<>();
        LinkedList<TreeNode> cur = new LinkedList<>();  //记录null的值

        pre.add(root);
        while (!pre.isEmpty()) {
            int size = pre.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = pre.pollFirst();
                cur.addLast(temp.right);  //先放right？？？？？？
                cur.addLast(temp.left);
            }
            int count = k % cur.size();
            for (int i = 0; i < count; i++) {   //右移K位
                TreeNode temp = cur.pollFirst();
                cur.addLast(temp);
            }
            for (int i = 0; i < size; i++) {
                TreeNode temp = pre.pollLast();
                temp.left = cur.pollLast();
                temp.right = cur.pollLast();
                if (temp.left != null) {
                    pre.addFirst(temp.left);
                }
                if (temp.right != null) {
                    pre.addFirst(temp.right);
                }
            }
            cur.clear();
        }
        return root;
    }




    public String maxLexicographical (String num) {
        // write code here
        char[] chars = num.toCharArray();
        int i = 0;
        int n = num.length();
        while (i < n) {
            if (chars[i] == '1') {
                i++;
            } else {
                break;
            }
        }
        while (i < n) {
            if (chars[i] == '0') {
                chars[i] = '1';
                i++;
            } else {
                break;
            }
        }
        return new String(chars);

    }

    @Test
    public void test() {
        System.out.println(minM(10,10));
    }
    public long minM (int n, int k) {
        // write code here
        //k进制，n：1出现的次数，m：数据范围
        long result = 0;
        int m = 1;
        while (true) {
            int nn = sum1(k, m);
            if (nn >= n) {
                result = m;
//                System.out.println(result);
                break;
            } else {
                m++;
            }
        }
        return result;
    }

    private int sum1(int k, int m) {//有问题
        int result = 0;
        for (int i = 0; i < m; i++) {
            //计算k进制侠每一个1出现的次数
            String value = Conversion(i + 1, k);
            result += Count(value);
        }
        return result;
    }

    //十进制转k进制
    private String Conversion(int num, int k) { //1
        String s = "";
        int m = 0;
        while (num >= k) {
            m = num % k;
            num = num / k;
            if (m > 9) {
                s = s + (char) ('A' + m - 10);
            } else {
                s = s + m;
            }
        }
        String result0 = s + num;
        StringBuilder temp = new StringBuilder(result0);
        temp = temp.reverse();
        return String.valueOf(temp);
    }

    //统计字符串1出现的次数
    private int Count(String str) {  //1
        char[] chars = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                result++;
            }
        }
        return result;
    }




}
