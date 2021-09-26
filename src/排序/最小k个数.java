package 排序;

public class 最小k个数 {
    private int[] result;
    private int count = 0;
    public int[] smallestK(int[] arr, int k) {
        if (k == 0 || arr.length < k) return new int[0];
        result = new int[k];
        quickSort(arr, 0, arr.length-1, k);
        return result;
    }
    private void quickSort(int[] nums, int p, int r, int k) {
        if (p > r) {
            return;
        }
        int q = partition(nums, p, r);
        if (q-p+1 == k) {
            for (int i = p; i <= q; ++i) {
                result[count++] = nums[i];
            }
        } else if (q-p+1 < k) {
            for (int i = p; i <= q; ++i) {
                result[count++] = nums[i];
            }
            quickSort(nums, q+1, r, k-(q-p+1));
        } else {
            quickSort(nums, p, q-1, k);
        }
    }
    private int partition(int[] nums, int p, int r) {
        int i = p-1;
        int j = p;
        while (j < r) {
            if (nums[j] < nums[r]) {
                swap(nums, j, i+1);
                i++;
            }
            j++;
        }
        swap(nums, i+1, r);
        return i+1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
