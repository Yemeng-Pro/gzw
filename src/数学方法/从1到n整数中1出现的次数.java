package 数学方法;

/**
 * 见官网解析，具体要讨论不同位上的1的出现次数变化规律。
 */
public class 从1到n整数中1出现的次数 {
    public static int NUMBEROf1Between1And_Solution(int n){
       int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args){
        int a = 1, b = 2, m = 10;
        int cnt = (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        //int d = NUMBEROf1Between1And_Solution(a);
        System.out.println(9 / 10);
        System.out.println(cnt);
    }
}
