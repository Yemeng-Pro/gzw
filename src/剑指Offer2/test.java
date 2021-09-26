package 剑指Offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-24 14:58
 */
public class test {
//    List<String> res = new LinkedList<>();
//    char[] c;
//    @Test
//    public void test() {
//        System.out.println(Arrays.toString(permutation("AAC")));
//
//    }
//    public String[] permutation(String s) {
//        c = s.toCharArray();
//        dfs(0);
//        return res.toArray(new String[res.size()]);
//    }
//    void dfs(int x) {
//        if(x == c.length - 1) {
//            res.add(String.valueOf(c)); // 添加排列方案
//            return;
//        }
//        HashSet<Character> set = new HashSet<>();
//        for(int i = x; i < c.length; i++) {
//            if(set.contains(c[i])) continue; // 重复，因此剪枝
//            set.add(c[i]);
//            swap(i, x); // 交换，将 c[i] 固定在第 x 位
//            dfs(x + 1); // 开启固定第 x + 1 位字符
//            swap(i, x); // 恢复交换
//        }
//    }
//    void swap(int a, int b) {
//        char tmp = c[a];
//        c[a] = c[b];
//        c[b] = tmp;
//    }
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        dfs(nums,visited,0);
        return res;

    }
    private void dfs(int[] nums, int[] visited, int k){
        if (tmp.size() == nums.length){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i = k; i<nums.length;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            dfs(nums,visited,k+1);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }


    }

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] visited = new int[candidates.length];
        dfs(candidates,0,target);
        return result;
    }

    private void dfs(int[] candidates, int index,int target) {
        if(target == 0){
            result.add(new ArrayList(temp));
        }
        temp.add(candidates[index]);
        dfs(candidates,index+1,target-candidates[index]);
        temp.remove(temp.size()-1);
        while(index < candidates.length-1&&candidates[index] == candidates[index+1]){
            index++;
        }
        dfs(candidates,index+1,target);

    }
}

