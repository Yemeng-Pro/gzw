package 纯编程题;

import org.junit.Test;

import javax.crypto.interfaces.PBEKey;

public class 把字符串转化为整数 {
    @Test
    public void test() {
        String str = " -42a22";
        System.out.println(strToInt(str));
    }


    public int strToInt(String str) {
        str = str.trim();
        boolean isNegative = false;
        boolean used = false;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!used && (str.charAt(i) == '-'||str.charAt(i) == '+')){
                used = true;
                isNegative = str.charAt(i) == '-';
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            } else {
                res = res * 10 + (str.charAt(i)-'0');
            }

        }
        return isNegative ? -res : res;
    }


    public int strToInt2(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        // 处理空
        if (n == 0) return 0;
        // 处理前置空格
        int i = 0;
        while (i < n && chars[i] == ' ') {
            i++;
        }
        // 全为空格
        if (i == n) return 0;
        // 处理符号
        int sign = 1;
        char c = chars[i];
        if (c == '-') {
            sign = -1;
            i++;
        } else if (c == '+') {
            i++;
        }
        // 真正处理数字
        // 整数范围-2147483648~2147483647
        int intAbsHigh = 214748364;
        int result = 0;
        while (i < n && chars[i] >= '0' && chars[i] <= '9') {
            int d = chars[i] - '0';
            // 判断再乘以10，加d之后，是否越界
            if (result > intAbsHigh) {
                if (sign==1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            if (result == intAbsHigh) {
                if ((sign == 1) && (d > 7)) return Integer.MAX_VALUE;
                if ((sign == -1) && (d > 8)) return Integer.MIN_VALUE;
            }
            // 正常逻辑
            result = result * 10 + d;
            i++;
        }
        return sign*result;
    }

}
