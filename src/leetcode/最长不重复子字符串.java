package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-03-29 19:27
 */
public class 最长不重复子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res,tmp);
        }
        return res;
    }
}
