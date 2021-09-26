package 双指针;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int p = 0;
        int q = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while (q < n) {
            char c = s.charAt(q);
            if (!set.contains(c)) {
                set.add(c);
                q++;
                if (q-p > maxLen) maxLen = q-p;
                continue;
            }
            while (set.contains(c)) {
                set.remove(s.charAt(p));
                p++;
            }
        }
        return maxLen;
    }
}
