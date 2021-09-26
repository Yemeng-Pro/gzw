package 剑指Offer2;

/**
 * @author shkstart
 * @create 2021-04-23 10:50
 */
public class 二分 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println(binarySearch(nums, k));

    }

    public static int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] == K) {
                return m;
            } else if (nums[m] > K) {
                h = m ;
            } else {
                l = m ;
            }
        }

        return -1;
    }
}
