package 哈希表;

import java.util.HashSet;

public class 交换和 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int n = array1.length;
        int m = array2.length;
        // 计算数组1的和
        int sum1 = 0;
        for (int i = 0; i < n; ++i) {
            sum1 += array1[i];
        }
        // 计算数组2的和，并且将元素放到哈希表中
        int sum2 = 0;
        HashSet<Integer> hashTable = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            sum2 += array2[i];
            hashTable.add(array2[i]);
        }
        // sum1+sum2是奇数，那⽆解
        int sum = sum1+sum2;
        if (sum % 2 == 1) return new int[0];
        // 遍历数组1中的每个元素，在哈希表中查找
        int diff = sum/2 - sum1;
        for (int i = 0; i < n; ++i) {
            int target = array1[i] + diff;
            if (hashTable.contains(target)) {
                return new int[] {array1[i], target};
            }
        }

        return new int[0];
    }
}
