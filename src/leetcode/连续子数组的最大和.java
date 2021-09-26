package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-03-29 15:07
 */
public class 连续子数组的最大和 {
    //    public int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum = sum + nums[j];
//                if (sum > max) {
//                    max = sum;
//                }
//            }
//        }
//        return max;
//    }
    public int maxSubArray(int[] nums) {
        //状态转移矩阵
        /**if(dp[i-1] > 0)
         *   dp[i] = d[i-1] + nums[i]
         * else
         *   dp[i] = nums[i]
         */
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            max = Math.max(sum, max);
        }
        return max;
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String ret = "";
        for (String str : nums)
            ret += str;
        return ret;
    }

    @Test
    public void test(){
        String a = "12";
        String b = "13";
        System.out.println(a.compareTo(b));
        System.out.println(1%1);

    }
    public boolean isStraight(int[] nums) {
        if (nums.length < 5)
            return false;

        Arrays.sort(nums);
        //统计癞子数量
        int cnt = 0;
        for(int num : nums){
            if(num == 0)
                cnt++;
        }
        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        return cnt >= 0;
    }
}