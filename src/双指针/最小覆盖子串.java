package 双指针;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        int minWSize = Integer.MAX_VALUE;
        int minWStart = -1;
        int minWEnd = -1;
        Map<Character, Integer> tmap = new HashMap<>(); //模式串
        Map<Character, Integer> wmap = new HashMap<>(); //滑动窗⼝
        for (int i = 0; i < t.length(); ++i) {
            int count = 1;
            if (tmap.containsKey(t.charAt(i))) {
                count += tmap.get(t.charAt(i));
            }
            tmap.put(t.charAt(i), count);
        }

        int n = s.length();
        int l = 0;
        int r = -1;

        while (r<n) {
            while (!match(wmap, tmap)) {
                r++;
                if (r > n-1) {
                    break;
                }
                char c = s.charAt(r);
                if (tmap.containsKey(c)) {
                    int count = 1;
                    if (wmap.containsKey(c)) {
                        count += wmap.get(c);
                    }
                    wmap.put(c, count);
                }
            }
            if (match(wmap, tmap)) {
                if (minWSize > r-l+1) {
                    minWSize = r-l+1;
                    minWStart = l;
                    minWEnd = r;
                }
                char c = s.charAt(l);
                if (tmap.containsKey(c)) {
                    int count = wmap.get(c);
                    if (count-1 == 0) {
                        wmap.remove(c);
                    } else {
                        wmap.put(c, count-1);
                    }
                }
                l++;
            }
        }
        if (minWStart == -1) return "";
        return s.substring(minWStart, minWEnd+1);
    }

    private boolean match(Map<Character, Integer> wmap, Map<Character, Integer> tmap) {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            Character key = entry.getKey();
            if (!wmap.containsKey(key)) return false;
            if (wmap.get(key) < entry.getValue()) return false;   //这里是小于我草！
        }
        return true;
    }


}
