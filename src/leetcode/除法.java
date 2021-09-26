package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-11 14:48
 */
public class 除法 {
    @Test
    public void test() {

        System.out.println(Integer.toBinaryString(-2>>>1));
        System.out.println(Integer.toBinaryString(-2>>1));
    }
    public int divide(int dividend, int divisor) {
        if(dividend==0||Math.abs(dividend)<Math.abs(divisor)) return 0;
        boolean flag;
        if(dividend>0&&divisor>0||dividend<0&&divisor<0){
            flag = true;
        }else{
            flag = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        int count = 0;
        while(count<=dividend){
            res++;
            count += divisor;
        }
        res--;
        if(!flag){
            res *= -1;
        }
        return res;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
//        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                right += one_word;
                count++;
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if (count == word_num) res.add(left);

            }
        }

        return res;
    }

}
