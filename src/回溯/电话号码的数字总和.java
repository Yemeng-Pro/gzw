package 回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 电话号码的数字总和 {
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        String[] mappings = new String[10];
        mappings[2] = "abc";
        mappings[3] = "def";
        mappings[4] = "ghi";
        mappings[5] = "jkl";
        mappings[6] = "mno";
        mappings[7] = "pqrs";
        mappings[8] = "tuv";
        mappings[9] = "wxyz";
//        char[] path = new char[digits.length()];
        List<Character> path = new ArrayList<>();
        backtrack(mappings, digits, 0, path);
        return result;
    }
    // k表示阶段
    // path路径
    // digits[k]+mappings确定当前阶段的可选列表
    private void backtrack(String[] mappings, String digits, int k, List<Character> path) {
        if (k == digits.length()) {
            StringBuilder a = new StringBuilder();
            for (Character str : path) {
                a.append(str);
            }
            result.add(String.valueOf(a));
            return;
        }
        String mapping = mappings[digits.charAt(k)-'0'];
        for (int i = 0; i < mapping.length(); ++i) {
            path.add(mapping.charAt(i));
            backtrack(mappings, digits, k+1, path);
            path.remove(path.size() - 1);
        }
    }
}
