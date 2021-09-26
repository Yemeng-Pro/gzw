package leetcode;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-03-24 16:53
 */
public class 数组中重复的数字 {
    
    @Test
    public void test(){
        int[] test = new int[]{0,3,2,1,2,5,3};
        System.out.println(findRepeatNumber(test));

    }
    public int findRepeatNumber(int[] nums) {
        //原地交换
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if (nums[i] != nums[nums[i]]){
                    swap(nums, i, nums[i]);
                }else{
                    return nums[i];
                }
            }

        }
        return -1;

    }
    private void swap(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
    
    
    
}
    
