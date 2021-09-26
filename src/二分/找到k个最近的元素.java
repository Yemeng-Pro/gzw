package 二分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到k个最近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int firstElem = -1;

        // 找第⼀个⼤于等于x的元素
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                if (mid == 0 || arr[mid - 1] < x) {
                    firstElem = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        // 查找最接近x的k个元素
        // TODO:…
        // 查找最接近x的k个元素
        int i = -1; // 往前遍历
        int j = -1; // 往后遍历
        if (firstElem == -1) {
            i = n - 1;
            j = n;
        } else {
            i = firstElem - 1;
            j = firstElem;
        }
        int[] result = new int[k];
        int count = 0;
        while (count < k && i >= 0 && j < n) {
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                result[count++] = arr[i];
                i--;
            } else {
                result[count++] = arr[j];
                j++;
            }
        }
        while (count < k && i >= 0) {
            result[count++] = arr[i];
            i--;
        }
        while (count < k && j < n) {
            result[count++] = arr[j];
            j++;
        }
        Arrays.sort(result);
        List<Integer> formattedResult = new ArrayList();
        for (int p = 0; p < k; ++p) {
            formattedResult.add(result[p]);
        }
        return formattedResult;
    }
}
