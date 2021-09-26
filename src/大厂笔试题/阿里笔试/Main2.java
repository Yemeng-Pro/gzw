package 大厂笔试题.阿里笔试;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-16 19:29
 */
public class Main2 {
    public static void main(String[] args) {


    }
    private long cnt = 0;
    private int[] tmp; // 在这里声明辅助数组，而不是在 merge() 递归函数中声明
    private List<int []> res;
    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }
    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }
    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] <= nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
//                this.cnt += m - i + 1; // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]

            }
            k++;
        }
        for (i = l; i <= h; i++)
            nums[i] = tmp[i];
    }
}
