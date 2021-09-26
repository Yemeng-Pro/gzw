package 剑指Offer2;



import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-24 16:32
 */
public class Test2 {
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }


    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        System.out.println("移除前" + t + "  当前cur=" +cur);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        System.out.println("移除后" + t + "  当前cur=" +cur);
        dfs(cur + 1, nums);
    }
}
