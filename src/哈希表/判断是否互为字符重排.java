package 哈希表;

import java.util.HashMap;

public class 判断是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        HashMap<Character, Integer> s1ht = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);
            int count = 1;
            if (s1ht.containsKey(c)) {
                count += s1ht.get(c);
            }
            s1ht.put(c, count);
        }
        // s2去跟s1匹配
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            if (!s1ht.containsKey(c)) {
                return false;
            }
            int count = s1ht.get(c);
            if (count == 0) return false;
            s1ht.put(c, count-1);
        }
        // 检查s1ht是否为空
        for (int i = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);
            if (s1ht.get(c) != 0) return false;
        }
        return true;
    }

}
