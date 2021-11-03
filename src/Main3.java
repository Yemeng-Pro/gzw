import org.junit.Test;

public class Main3 {
    public int solution(int n) {
        if (n < 10) {
            return n;
        } else if (n <= 18) {
            int num1 = (n % 10) + 1;
            int num2 = n - num1;
            int result = num1 * 10 + num2;
            return result;
        } else if (n <= 27) {
            int temp = n % 10;
            if (temp == 9 || temp == 0) {
                if (temp == 9) {
                    return 100 + solution(n - 1);
                } else {
                    return 200 + solution(n - 2);
                }
            } else {
                int num1 = (n % 10) + 1;
                int num2 = n - num1;
                return num1 * 100 + solution(num2);
            }

        } else if (n <= 36) {
            int temp = n % 10;
            if (temp == 9 || temp == 0) {
                if (temp == 9) {
                    return 1000 + solution(n - 1);
                } else {
                    return 2000 + solution(n - 2);
                }
            } else{
                int num1 = (n % 10) + 1;
                int num2 = n - num1;
                return num1 * 1000 + solution(num2);
            }
        } else if (n <= 45) {
            int temp = n % 10;
            if (temp == 9 || temp == 0) {
                if (temp == 9) {
                    return 10000 + solution(n - 1);
                } else {
                    return 20000 + solution(n - 2);
                }
            } else{
                int num1 = (n % 10) + 1;
                int num2 = n - num1;
                return num1 * 10000 + solution(num2);
            }
        } else{
            int temp = n % 10;
            if (temp == 9 || temp == 0) {
                if (temp == 9) {
                    return 100000 + solution(n - 1);
                } else {
                    return 200000 + solution(n - 2);
                }
            } else{
                int num1 = (n % 10) + 1;
                int num2 = n - num1;
                return num1 * 100000 + solution(num2);
            }
        }
    }


    @Test
    public void test() {
        int n = 20;
        System.out.println(solution(n));
    }

    private static boolean istrue(int num, int n) {
        int count = 0;
        while (num != 0) {
            int temp = num%10;
            num = num / 10;
            count += temp;
        }
        return count == n;
    }
}
