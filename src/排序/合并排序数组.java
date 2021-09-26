package 排序;

public class 合并排序数组 {
    //思路一：创建临时空间，最后将排序好后的结果赋值给A数组
    //之所以要使用临时变量，是因为如果直接合并到数组 AA 中，AA 中的元素可能会在取出之前被覆盖。
    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                temp[cur++] = B[p2++];
            } else if (p2 == n) {
                temp[cur++] = A[p1++];
            } else if (A[p1] <= B[p2]) {
                temp[cur++] = A[p1++];
            } else {
                temp[cur++] = B[p2++];
            }
        }
        System.arraycopy(temp, 0, A, 0, temp.length);
    }

    //思路二：从后往前排序
    public void merge2(int[] A, int m, int[] B, int n) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i];
                i--;
            } else {
                A[k--] = B[j];
                j--;
            }
        }
        while (i >= 0) {
            A[k--] = A[i--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
