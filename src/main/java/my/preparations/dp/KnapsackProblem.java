package my.preparations.dp;

/**
 * Let’s take Merry’s example, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:
 * <p>
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 */
public class KnapsackProblem {
    private static int knapsackRecursive(int[] weights, int[] profit, int capacity) {
        int current = 0;
        return knapsackRecursiveUtil(weights, profit, capacity, current);
    }

    private static int knapsackRecursiveUtil(int[] weights, int[] profit, int capacity, int currentIndex) {
        if (capacity <= 0) return 0;
        if (currentIndex >= weights.length) return 0;

        int profitWithoutCurrent = knapsackRecursiveUtil(weights, profit, capacity, currentIndex + 1);
        int profitWithCurrent = 0;
        if (weights[currentIndex] <= capacity) {
            profitWithCurrent = profit[currentIndex] + knapsackRecursiveUtil(weights, profit, capacity - weights[currentIndex], currentIndex + 1);
        }
        return Math.max(profitWithCurrent, profitWithoutCurrent);
    }

    private static int solveKnapshackMemoization(int[] weights, int[] profits, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return solveKnapshackMemoizationUtil(weights, profits, capacity, 0, dp);
    }

    private static int solveKnapshackMemoizationUtil(int[] weights, int[] profits, int capacity, int currentIndex, Integer[][] dp) {
        if (capacity <= 0) return 0;
        if (currentIndex >= weights.length) return 0;
        if (dp[currentIndex][capacity] != null) return dp[currentIndex][capacity];

        int profitWithoutCurrent = solveKnapshackMemoizationUtil(weights, profits, capacity, currentIndex + 1, dp);
        int profitWithCurrent = 0;
        if (weights[currentIndex] <= capacity) {
            profitWithCurrent = profits[currentIndex] + solveKnapshackMemoizationUtil(weights, profits, capacity - weights[currentIndex], currentIndex + 1, dp);
        }
        dp[currentIndex][capacity] = Math.max(profitWithCurrent, profitWithoutCurrent);
        return dp[currentIndex][capacity];
    }

    private static int solveKnapshackIterativeDp(int[] weights, int[] profits, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= capacity; i++) {
            if (weights[0] <= i) {
                dp[0][i] = profits[0];
            }
        }

        for (int i = 1; i < profits.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int profit1 = dp[i - 1][j], profit2 = 0;

                if (weights[i] <= j) {
                    profit2 = profits[i] + dp[i - 1][j - weights[i]];
                }
                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        return dp[profits.length - 1][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsackRecursive(weights, profits, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = knapsackRecursive(weights, profits, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        maxProfit = solveKnapshackMemoization(weights, profits, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapshackMemoization(weights, profits, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);


        maxProfit = solveKnapshackIterativeDp(weights, profits, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapshackIterativeDp(weights, profits, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
