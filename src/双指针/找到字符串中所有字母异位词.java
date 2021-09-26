package 双指针;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> result = new ArrayList<>();
        if (m > n) {
            return null;
        }
        int[] need = new int[26];
        for (int i = 0; i < m; i++) {
            int index = p.charAt(i) - 'a';
            need[index]++;
        }
        //滑动窗口匹配
        int[] match = new int[26];
        int p1 = 0;
        int q = 0;
        while (q < m) {
            int index = s.charAt(q) - 'a';
            match[index]++;
            q++;
        }
        if (compute(match, need)) {
            result.add(p1);
        }
        while (q < n) {
            match[s.charAt(p1) - 'a']--;
            match[s.charAt(q) - 'a']++;
            p1++;
            q++;
            if (compute(match, need)) {
                result.add(p1);
            }
        }
        return result;
    }

    private static boolean compute(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }



}
