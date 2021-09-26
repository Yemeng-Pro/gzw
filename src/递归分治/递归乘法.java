package 递归分治;

public class 递归乘法 {
    public int multiply(int A, int B) {
        // a个b相加
        if (A == 1) return B;
        int halfValue = multiply(A/2, B);
        if (A%2 == 1) {
            return halfValue+halfValue+B;
        } else {
            return halfValue+halfValue;
        }
    }
    //尽可能少使用加法
    public int multiply2(int A, int B) {
        int n = Math.min(A, B);
        int k = Math.max(A, B);
        if (n == 1) return k;
        // n个k相加=(n/2个k相加)+(n/2个k相加)+0(或k)
        int halfValue = multiply2(n/2, k);
        if (n%2 == 1) {
            return halfValue+halfValue+k;
        } else {
            return halfValue+halfValue;
        }
    }
}
