package leetcode;


import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] res = new Long[n];
        for (int i = 0; i < n; i++) {
            Long a = in.nextLong();
            Long b = in.nextLong();
            Long father = findFather(1L,a, b);
            Long cell1 = getCell(a);
            Long cell2 = getCell(b);
            Long cell3 = getCell(father);
            res[i] = cell1+cell2-2*cell3;
        }
        for(Long num:res){
            System.out.println(num);
        }
    }

    private static Long getCell(Long num) {
        long temp = 0L;
        while (Math.pow(2,temp)<=num) temp++;
        return temp;
    }
    private static Long findFather(Long root,Long a,Long b) {
        if (root > a && root > b) {
            return -1L;
        }
        if (root.equals(a) || root.equals(b)) {
            return root;
        }
        Long left = findFather(root * 2, a, b);
        Long right = findFather(root * 2 + 1, a, b);
        if (left != -1L && right != -1L) {
            return root;
        }
        if (left != -1L) {
            return left;
        }
        if (right != -1L) {
            return right;
        }
        return -1L;
    }



}