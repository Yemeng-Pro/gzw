package 哈希表;

import java.util.HashMap;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // 哈希表,key数本身,value是下标
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            hashTable.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (hashTable.containsKey(target-nums[i])) {
                int value = hashTable.get(target-nums[i]);
                if (value != i) {
                    return new int[] {i, value};
                }
            }
        }
        return new int[0];
    }
}
