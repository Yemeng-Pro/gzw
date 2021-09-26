package Test;


import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-06-04 19:08
 */
public class 买股票 {
    @Test
    public void test() {
        int[] a = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(a));
    }
    private static int maxProfit = 0;
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }
}
