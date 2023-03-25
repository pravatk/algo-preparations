package my.preparations.dp;

/**
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Example 1:
 * <p>
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * Example 2:
 * <p>
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * Example 3:
 * <p>
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
public class EqualSubsetSum {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartitionRecur(num));
        int[] num1 = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartitionRecur(num1));
        int[] num2 = new int[]{2, 3, 4, 6};
        System.out.println(canPartitionRecur(num2));

        System.out.println(canPartitionMemoized(num));
        System.out.println(canPartitionMemoized(num1));
        System.out.println(canPartitionMemoized(num2));
    }

    static boolean canPartitionRecur(int[] num) {
        int sum = 0;
        for (int aNum : num)
            sum += aNum;

        if (sum % 2 != 0) return false;

        return canPartitionRecurUtil(num, sum / 2, 0);
    }

    static boolean canPartitionRecurUtil(int[] num, int target, int currentIndex) {
        if (target == 0) return true;
        if (currentIndex >= num.length) return false;

        if (num[currentIndex] <= target && canPartitionRecurUtil(num, target - num[currentIndex], currentIndex + 1)) {
            return true;
        }
        return canPartitionRecurUtil(num, target, currentIndex + 1);
    }

    static boolean canPartitionMemoized(int[] num) {
        int sum = 0;
        for (int aNum : num)
            sum += aNum;

        if (sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];

        return canPartitionMemoizedUtil(num, sum / 2, dp, 0);
    }

    private static boolean canPartitionMemoizedUtil(int[] num, int target, Boolean[][] dp, int currentIndex) {
        if (target == 0) return true;
        if (currentIndex >= num.length) return false;
        if (dp[currentIndex][target] != null) return dp[currentIndex][target];
        boolean result;
        if (num[currentIndex] <= target && canPartitionMemoizedUtil(num, target - num[currentIndex], dp, currentIndex + 1)) {
            result = true;
            dp[currentIndex][target] = true;
            return result;
        }

        result = canPartitionMemoizedUtil(num, target, dp, currentIndex + 1);
        dp[currentIndex][target] = result;
        return result;
    }
}
