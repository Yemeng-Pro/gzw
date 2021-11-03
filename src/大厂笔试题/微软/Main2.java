package 大厂笔试题.微软;

import org.junit.Test;

public class Main2 {
    @Test
    public void test() {
        int[] A = {3,5,1};
        System.out.println(solution(A));
        int B = 2601;
        System.out.println(caculate(B));
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * Math.pow(10, i);
        }
        sum = sum * 17;
        return caculate(sum);
    }

    private int caculate(int sum) {
        int result = 0;
        while (sum != 0) {
            int temp = sum % 10;
            sum /= 10;
            result += temp;
        }
        return result;
    }
}
