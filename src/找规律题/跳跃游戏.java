package 找规律题;

import org.junit.Test;

public class 跳跃游戏 {
    @Test
    public void test(){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = 0;
        for(int i = 0;i < n;i++){
            if(i > target){
                return false;
            }
            if(i + nums[i] > target){
                target = i+nums[i];
            }
            if(target >= n-1) {
                return true;
            }
        }
        return false;
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
