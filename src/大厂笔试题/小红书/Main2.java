package 大厂笔试题.小红书;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int a = func1(array,n);
        int b = func2(array,n);
        System.out.println(Math.min(a, b));
    }

    @Test
    public void test() {
        Integer[] n = {2, 5, 3, 1};
        Arrays.sort(n, ((o1, o2) -> o2 - o1));
        System.out.println(Arrays.toString(n));
    }
    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static int func1(Integer[] array, int n) {
        int res = 0;
        Integer[] sortArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortArray[i] = array[i];
        }
        Arrays.sort(sortArray);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (array[i] != sortArray[i]) {
                int j = map.get(sortArray[i]);
                map.put(array[i], j);
                map.put(sortArray[i], i);
                swap(array, i, j);
                res++;
            }
        }
        return res;
    }
    private static int func2(Integer[] array, int n) {
        int res = 0;
        Integer[] sortArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortArray[i] = array[i];
        }
        Arrays.sort(sortArray, Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (array[i] != sortArray[i]) {
                int j = map.get(sortArray[i]);
                map.put(array[i], j);
                map.put(sortArray[i], i);
                swap(array, i, j);
                res++;
            }
        }
        return res;

    }
}
