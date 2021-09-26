import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-17 22:26
 */
public class Main2 {
    private static int res = 0;
    public static void main(String[] args) {
        //数据读取
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                temp.add(in.nextInt());
            }
            array.add(temp);
        }
        List<Integer> nums = array.get(0);
        find(nums);
        System.out.println(res);


    }

    private static void find(List<Integer> num) {
        for (int i = 0; i < num.size(); i++) {
            int[] dp = new int[num.size()];
            int j = i+1;
            dp[0] = num.get(i);
            for (int k = 1; k < num.size(); k++) {
                if (j == num.size()) {
                    j = 0;
                }
                dp[k] = dp[k - 1] > 0 ? dp[k - 1] + num.get(j) : num.get(j);
                j++;
                res = Math.max(res,dp[k]);
            }
        }
    }
}
