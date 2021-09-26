package 纯编程题;

public class 验证回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return (x == revertedNumber) || (x == revertedNumber/10);
    }

    public boolean isPalindrome2(int x) {
        // -2147483648 ~2147483647
        int[] digits = new int[10];
        if (x < 0) return false;
        int k = 0;
        // 将x转化成字符串数组
        while (x != 0) {
            digits[k] = x % 10;
            x = x / 10;
            k++;
        }
        // 判断回⽂串
        for (int i = 0; i < k/2; ++i) { // 举例验证
            if (digits[i] != digits[k-i-1]) { // 举例验证
                return false;
            }
        }
        return true;
    }
}