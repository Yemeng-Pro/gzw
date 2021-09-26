package alibaba;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-26 18:50
 */
public class Main1 {
    @Test
    public void test(){
        int[] a = {-3,-2,-5,3,-4};
        int sum = -4;
        int target = -1;
        int closestNum = Integer.MAX_VALUE;
        System.out.println(Math.abs(sum-target) < Math.abs(closestNum-target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length-2;i++){
            int l = i+1,r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (Math.abs(sum-target) < Math.abs(closestNum-target)){
                    closestNum = sum;
                }
                if(sum>target) r--;
                if(sum<target) l++;
                if(sum == target) return target;
            }
        }
        return closestNum;
    }
}
