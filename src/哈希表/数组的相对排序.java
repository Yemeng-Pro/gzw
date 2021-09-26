package 哈希表;

import java.util.Arrays;
import java.util.HashMap;

public class 数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr2中每个数字在arr1中出现的次数
        HashMap<Integer, Integer> counts = new HashMap<>();
        // 先⽤arr2构建hash表
        for (int i = 0; i < arr2.length; ++i) {
            counts.put(arr2[i], 0);
        }
        // 扫描arr1统计arr2中每个数字在arr1中出现的次数
        for (int i = 0; i < arr1.length; ++i) {
            if (counts.containsKey(arr1[i])) {
                int oldCount = counts.get(arr1[i]);
                counts.put(arr1[i], oldCount+1);
            }
        }
        int[] result = new int[arr1.length];
        int k = 0;
        // 将counts的数据按照arr2的顺序输出
        for (int i = 0; i < arr2.length; ++i) {
            int count = counts.get(arr2[i]);
            for (int j = 0; j < count; ++j) {
                result[k+j] = arr2[i];
            }
            k += count;
        }
        // 将arr1中未出现在arr2中的数据有序输出到result
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; ++i) {
            if (!counts.containsKey(arr1[i])) {
                result[k++] = arr1[i];
            }
        }
        return result;
    }
}
