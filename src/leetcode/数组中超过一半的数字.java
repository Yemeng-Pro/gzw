package leetcode;

/**
 * @author shkstart
 * @create 2021-03-28 20:10
 */
public class 数组中超过一半的数字 {
//    public int majorityElement(int[] nums) {
//        HashMap<Integer,Integer> set = new HashMap<>();
//        for (int num : nums) {
//            set.put(num,(set.getOrDefault(num,0) + 1));
//            if (set.get(num) > nums.length/2) {
//                return num;
//            }
//
//        }
//        return 0;
//    }
    public int majorityElement(int[] nums) {
        quickSort(nums,nums.length-1);
        return nums[nums.length/2];
    }

    private void quickSort(int[] nums, int n) {
        quickSort_c(nums,0,n);
    }

    private void quickSort_c(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums,l,r);
        quickSort_c(nums, l, p - 1);
        quickSort_c(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int point = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] < point) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        return i;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int point = (l+r)/2;
        mergeSort(nums,l,point);
        mergeSort(nums, point + 1, r);
        merge(nums,l,point,r);

    }

    private void merge(int[] nums, int l, int point, int r) {
        //定义两个指针
        int i = l;
        int j = point + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= point && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = point;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[k++] = nums[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]

        int t = 0;
        int tempp = l;
        while (tempp <= r) {
            nums[tempp++] = temp[t++];
        }

    }




}
