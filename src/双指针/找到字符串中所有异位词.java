package 双指针;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m > n) return new ArrayList<>();
        int[] needs = new int[26];
        for (int i = 0; i < m; ++i) {
            needs[p.charAt(i)-'a']++;
        }
        int[] matched = new int[26];
        int startp = 0;
        int endp = 0;
        List<Integer> result = new ArrayList<>();
        while (endp < m) {
            matched[s.charAt(endp)-'a']++;
            endp++;
        }
        if (same(needs, matched)) {
            result.add(startp);
        }
        while (endp < n && startp < n) {
            matched[s.charAt(startp)-'a']--;
            matched[s.charAt(endp)-'a']++;
            startp++;
            endp++;
            if (same(needs, matched)) {
                result.add(startp);
            }
        }
        return result;
    }
    private boolean same(int[] needs, int[] matched) {
        for (int i = 0; i < needs.length; ++i) {
            if (needs[i] != matched[i]) return false;
        }
        return true;
    }
}
