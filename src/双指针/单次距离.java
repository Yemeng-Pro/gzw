package 双指针;

import java.util.ArrayList;
import java.util.List;

public class 单次距离 {
    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> w1ps = new ArrayList<>();
        List<Integer> w2ps = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word.equals(word1)) {
                w1ps.add(i);
            } else if (word.equals(word2)) {
                w2ps.add(i);
            }
        }
        int p1 = 0;
        int p2 = 0;
        int minRet = Integer.MAX_VALUE;
        while (p1 < w1ps.size() && p2 < w2ps.size()) {
            int pos1= w1ps.get(p1);
            int pos2 = w2ps.get(p2);
            if (pos1 > pos2) {
                if (minRet > pos1-pos2) {
                    minRet = pos1-pos2;
                }
                p2++;
            } else {
                if (minRet > pos2-pos1) {
                    minRet = pos2-pos1;
                }
                p1++;
            }
        }
        return minRet;
    }
}
