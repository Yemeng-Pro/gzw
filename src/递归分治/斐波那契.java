package 递归分治;

public class 斐波那契 {
    private int mod = 1000000007;
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n-1)+fib(n-2))%mod;
    }



    //备忘录
    private int[] memo;
    public int fib2(int n) {
        memo = new int[n+1];
        return fib_r(n);
    }
    private int fib_r(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = (fib_r(n-1)+fib_r(n-2))%mod;
        return memo[n];
    }
}
