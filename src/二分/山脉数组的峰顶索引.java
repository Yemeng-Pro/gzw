package 二分;

public class 山脉数组的峰顶索引 {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (mid == 0) { //特殊处理，防止数组越界
                low = mid+1;
            } else if (mid == n-1) {
                high = mid-1;
            } else if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if (arr[mid] > arr[mid-1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
