package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 单次出现频率 {
    private Map<String, Integer> map = new HashMap<>();
    public void WordsFrequency(String[] book) {
        for (String word : book) {
            int count = 1;
            if (map.containsKey(word)) {
                count += map.get(word);
            }
            map.put(word, count);
        }
    }
    public int get(String word) {
        if (!map.containsKey(word)) {
            return 0;
        }
        return map.get(word);
    }
}
