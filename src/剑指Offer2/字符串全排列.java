package 剑指Offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-12 22:31
 */
public class 字符串全排列 {

    public static void main(String[] args) {
        String[] res = permutation("aab");
        System.out.println(Arrays.toString(res));


    }

    private static List<Character> temp = new ArrayList<>();
    private static List<String> res = new ArrayList<>();
    public static String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars, visited);
        String[] res2 = res.toArray(new String[s.length()]);
        return res2;

    }

    private static void dfs(char[] chars, boolean[] visited) {
        if (temp.size() == chars.length) {
            String answer = "";
            for (int i = 0; i < temp.size(); i++) {
                answer += temp.get(i);
            }
            res.add(answer);
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || i > 0 && !visited[i - 1] && chars[i] == chars[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.add(chars[i]);
            dfs(chars, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < m || j < n){
            if(i < m){
                res[index++] = nums2[j++];
            }else if(j != n){
                res[index++] = nums1[i++];
            }else if(nums1[i] <= nums2[j]){
                res[index++] = nums1[i++];
            }else{
                res[index++] = nums2[j++];
            }
        }
    }
}
