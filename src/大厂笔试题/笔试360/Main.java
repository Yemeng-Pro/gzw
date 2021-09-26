package 大厂笔试题.笔试360;
import java.util.Scanner;

/**
 * @author GongZiWei
 * @create 2021-04-17 14:47
 */
public class Main {
    private static int[][] dp = new int[100][100];//定义动态规划矩阵
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] str = string.toCharArray();
        int[] add = {0,100, 200, 360, 220};//添加及删除的开销，前面加个0是为了从1开始
        int[] del = {0,120, 350, 200, 320};

        //dp[i][j]表示从序号i到j变成回文串时的最小代价，而dp[i][j]可以由dp[i+1][j]和dp[i][j-1]得到
        //如果第i个字符和第j个字符不同，那么dp[i][j]可由dp[i+1][j]删除第i个字符，或者在字符串最末尾添加第i个字符得到，
        //也可以由dp[i][j-1]删除第j个字符，或者在最左侧添加第j个字符得到。
        for (int j = 1; j < str.length; j++) {
            for (int i = j-1; i >= 0 ; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    int temp1 = Math.min(dp[i + 1][j] + del[str[i] - '0'],
                                         dp[i + 1][j] + add[str[i] - '0']);
                    int temp2 = Math.min(dp[i][j - 1] + del[str[j] - '0'],
                                         dp[i][j - 1] + add[str[j] - '0']);
                    dp[i][j] = Math.min(temp1, temp2);

                }
            }
        }
        System.out.println(dp[0][str.length - 1]);

    }
}
