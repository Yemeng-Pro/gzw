package 大厂笔试题.微软;

import java.util.Arrays;

public class Main3 {
    public int solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        int[] record = new int[N];
        for (int n : A) {
            record[n - 1]++;
        }
        for (int n : B) {
            record[n - 1]++;
        }
        Arrays.sort(record);
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (record[i] == 0) break;
            res += (i + 1) * record[i];
        }
        return res;
    }
}
