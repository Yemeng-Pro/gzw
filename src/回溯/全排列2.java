package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        dfs(nums,visited);
        return res;
    }
    private void dfs(int[] nums, int[] visited){
        if (tmp.size() == nums.length){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(visited[i] == 1 || (i > 0 && nums[i] == nums[i-1] && visited[i-1] == 0)) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            dfs(nums,visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
