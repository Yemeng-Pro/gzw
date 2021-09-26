package 大厂笔试题.网易;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] array = new int[N];
            for (int j = 0; j < N; j++) {
                array[j] = in.nextInt();
            }
            int[] range = findshiye(array, M-1);
            int left = range[0];
            int old1 = find666(array, 0, left);
            int right  = range[1];
            int old2 = find666(array, right, N - 1);
            int result = old1 + old2;
            System.out.println(result);
        }
    }

    //先找到小易的视野边界
    //注意在返回值上+1-1
    private static int[] findshiye(int[] array, int M) {
        int cur = array[M];
        int left = 0;
        int right = 0;
        //找左视野边界
        for (int i = M; i >= 0; i--) {
            if (i == 0 && array[i] <= cur) {
                left = -1;
            }else if (array[i] > cur) {
                left = i;
                left--;
                break;
            }

        }
        //找右视野边界
        for (int i = M; i < array.length; i++) {
            if (i == array.length - 1 && array[i] <= cur) {
                right = array.length;
            }else if (array[i] > cur) {
                right = i;
                right++;
                break;
            }

        }
        return new int[]{left, right};
    }

    //查找该区间内老六的人数
    private static int find666(int[] array, int left, int right) {
        if (left > right || left < 0 || right > array.length-1) {
            return 0;
        }
        if (left == right || right == left + 1) {
            return 1;
        }
        //查找区间内的峰值
        int count = 0;
        for (int i = left; i <= right; i++) {
            if ((i > left && i < right)
                    && (array[i] > array[i - 1] && array[i] > array[i + 1])) {
                count++;
            } else if (i == left) {
                continue;
            } else if (i == right) {
                continue;
            }
        }
        return count + 1;
    }
}
