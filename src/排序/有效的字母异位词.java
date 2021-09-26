package 排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 有效的字母异位词 {
    //排序、哈希
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < str1.length; ++i) {
            if (str1[i] != str2[i]) return false;
        }
        return true;
    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                table[t.charAt(i) - 'a']--;
                if (table[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
        //若不是asc2编码，则用哈希表
        public boolean isAnagram2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> table = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                table.put(ch, table.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                table.put(ch, table.getOrDefault(ch, 0) - 1);
                if (table.get(ch) < 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
