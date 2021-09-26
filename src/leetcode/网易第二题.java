package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-04-10 22:06
 */
public class 网易第二题 {
    private static Stack<Integer> left = new Stack<>();
    private static Stack<Integer> right = new Stack<>();
    private static int max = 0;

    @Test
    public void test() {
        left.push(0);
        right.push(0);
        int[] nums = {1,2,1,2,3,4,3};
        System.out.println(fuck(nums));
    }

    public int fuck(int[] nums){
        backTracing(nums,"left",0,0);
        return max;
    }

    private void backTracing(int[] nums,String dir,int count,int cur){
        if (cur == nums.length) {
            max = Math.max(max,count);
            return;
        }
        if ("left".equals(dir) ){
            if(left.peek()==nums[cur]){
                count += 1;
                left.push(nums[cur]);
                backTracing(nums,"left",count,cur+1);
                left.pop();
                backTracing(nums,"right",count-1,cur);
            }else{
                left.push(nums[cur]);
                backTracing(nums,"left",count,cur+1);
                left.pop();
                backTracing(nums,"right",count,cur);
            }

        }
        if ("right".equals(dir) ){
            if(right.peek()==nums[cur]){
                count += 1;
            }
            right.push(nums[cur]);
            backTracing(nums,"left",count,cur+1);

        }

    }
}
