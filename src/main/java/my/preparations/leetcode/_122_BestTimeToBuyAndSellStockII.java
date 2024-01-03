package my.preparations.leetcode;

public class _122_BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] price1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(price1));

        price1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(price1));

        price1 = new int[]{7, 6, 5, 4, 3, 2};
        System.out.println(maxProfit(price1));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
