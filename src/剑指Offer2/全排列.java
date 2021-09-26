package 剑指Offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-29 14:37
 */
public class 全排列 {
    static ArrayList<String > t = new ArrayList<>();
    static List<List<String>> ans = new ArrayList<>();
    private static String[] nums = new String[]{"a","b"};
    public static void main(String[] args) {
        int[] a = {1,2};
        subsets();
        System.out.println(ans);

    }

    public static List<List<String>> subsets() {
        dfs(0);
        return ans;
    }

    public static void dfs(int cur) {
        if (cur == nums.length) {
            ans.add(new ArrayList<String>(t));
            return;
        }
        t.add(nums[cur]);
//        System.out.println(t + String.valueOf(cur));
        dfs(cur + 1);
        t.remove(t.size() - 1);
//        System.out.println(t + String.valueOf(cur));
        dfs(cur + 1);
    }
}
