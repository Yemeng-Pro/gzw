package 数学方法;

import java.util.HashMap;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        Solution a = new Solution();
        int[] b = new int[]{1,2,2,2,2,3};
        System.out.println(a.majorityElement(b));
    }
}

class Solution {
    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        for(int num:nums){
            int count = 0;
            for(int elem: nums){
                if(elem == num){
                    count += 1;
                }
            }
            if(count > nums.length / 2){
                return num;
            }
        }
        return -1;
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                map.put(num, 1);
            }

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
