package 大厂笔试题.jingdong;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int count  = 0;
        List<Integer> list = new ArrayList<>();
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int temp = entry.getKey();
            int temp_count = entry.getValue();
            if (temp_count > count) {
                count = temp_count;
                list.clear();
                list.add(temp);
            } else if (temp_count == count) {
                list.add(temp);
            }
        }
        int result_p = 0;
        int result_q = 0;
        int length = n;
        for (Integer number : list) {
            int p = 0;
            int q = n-1;
            while (array[p] != number || array[q] != number) {
                p++;
                q--;
            }
            if (q - p + 1 < length) {
                result_p = p;
                result_q = q;
            }
        }
        result_p++;
        result_q++;
        String result = result_p + " " + result_q;
        System.out.println(result);
    }
}
