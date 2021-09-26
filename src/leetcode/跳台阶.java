package leetcode;

/**
 * @author shkstart
 * @create 2021-03-25 13:37
 */
public class 跳台阶 {
    public int numWays(int n) {
        if(n<=1)
            return n;
        int pre1 = 1;
        int pre2 = 0;
        int jump = 0;
        for(int i = 2; i <= n; i++){
            jump = pre2 + pre1;
            pre2 = pre1;
            pre1 = jump;
        }
        return jump;

    }

    public static void main(String[] args) {
        System.out.println(-5%3);
    }
}
