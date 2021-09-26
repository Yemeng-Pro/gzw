package 排序;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        int p = 0;
        int q = nums.length-1;
        while (p < q) {
            if (nums[p] != 2) {
                p++;
                continue;
            }
            if (nums[q] == 2) {
                q--;
                continue;
            }
            swap(nums, p, q);
            p++;
            q--;
        }
        int i = 0;
        int j = p;
        if (nums[j] == 2) j--;
        while (i < j) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[j] == 1) {
                j--;
                continue;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}
