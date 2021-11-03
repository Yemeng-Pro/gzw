package 大厂笔试题.B站;

import 剑指Offer2.Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _a;
        try {
            _a = in.nextLine();
        } catch (Exception e) {
            _a = null;
        }

        String _b;
        try {
            _b = in.nextLine();
        } catch (Exception e) {
            _b = null;
        }

        res = new Main2().reorder(_a, _b);
        System.out.println(res);
    }

    public String reorder(String a, String b) {
        ArrayList<Integer> array = new ArrayList<>();
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            int index = find(A, B[i]);
            if (index != -1) {
                array.add(index);
            }
        }
        if (array.size() == 0) return a;
        int n = array.size() - 1;
        for (int i = 0; i <= n / 2; i++) {
            swap(A, array.get(i), array.get(n-i));
        }
        return new String(A);
    }

    private static void swap(char[] A, int i, int j) {
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static int find(char[] A, char target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }



    public String reorder2(String a, String b) {
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int[] mapA = new int[26];
        int[] mapB = new int[26];
        //构建第一个滑动窗口
        for (int i = 0; i < B.length; i++) {
            mapB[B[i]-'A']++;
            mapA[A[i]-'A']++;
        }
        if (match(mapA, mapB)) {
            System.arraycopy(B, 0, A, 0, B.length);
            return new String(A);
        }
        int i = B.length;
        while (i < A.length) {
            mapA[A[i-B.length]-'A']--;
            mapA[A[i]-'A']++;
            if (match(mapA, mapB)) {
                System.arraycopy(B, 0, A, 0, B.length);
                return new String(A);
            }
            i++;
        }
        return null;
    }

    private static boolean match(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }
}
