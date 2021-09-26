package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 两个数的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashTable = new HashSet<>();
        for (int i = 0; i < nums1.length; ++i) {
            hashTable.add(nums1[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (hashTable.contains(nums2[i])) {
                hashTable.remove(nums2[i]);
                result.add(nums2[i]);
            }
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
