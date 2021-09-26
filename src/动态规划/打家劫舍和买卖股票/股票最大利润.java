package 动态规划.打家劫舍和买卖股票;

public class 股票最大利润 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - cost);
        }


//        for(int price : prices) {
//            cost = Math.min(cost, price);
//            profit = Math.max(profit, price - cost);
//        }
        return profit;
    }
}
