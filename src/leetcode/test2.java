package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-31 10:00
 */
class Test2 {
    public static void main(String[] args) {
        //创建线程任务
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable running");
            }
        };
        //将Runnable对象传给Thread
        Thread t = new Thread(r);
        //启动线程
        t.start();
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);      // 排序后便于去重
        dfs(res, new ArrayList<>(), 0, nums.length, nums);
        return res;
    }
    // dfs - 递归函数
    public void dfs(List<List<Integer>> res, List<Integer> list, int index, int len, int[] nums){
        if(index == len){   // [基本情况] 如果游标到达尾部，将当前list拷贝放入res中
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(res, list, index + 1, len, nums); // 选择当前的数
        list.remove(list.size() - 1);   // 回溯 - 将当前添加的数删除
        while (index != 0 && nums[index-1] == nums[index]  ){ // 去重，不选当前数递归时直接跳过重复数
            index++;    // 所有重复数的可能性在前面递归中均会出现
        }
        dfs(res, list, index + 1, len, nums); // 不选择当前的数
    }
    @Test
    public void test(){
        int a = 0;
        System.out.println(a<<2);
    }
}
