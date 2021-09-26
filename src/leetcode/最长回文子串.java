package leetcode;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-04-10 14:42
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() <= 2) {
            return s.substring(0,1);
        }
        int start = 0,end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    @Test
    public void test() {
//        System.out.println(longestPalindrome("abccbadd"));

        Integer a = 12;
        int length = a;
//        char[] c =
        System.out.println(-10/-3);

    }




}
