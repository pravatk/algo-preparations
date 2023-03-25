package my.preparations.dp;

public class SubSetSumProblem {
    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 10, 12, 5, 2};
        SubSetSumProblem s = new SubSetSumProblem();
        System.out.println(s.isSubSetSumTabulation(a, 78));
        System.out.println(s.isSubSetSumTabulation(a, 29));

        System.out.println(s.isSubsetSumMemoized(a, 78));
        System.out.println(s.isSubsetSumMemoized(a, 29));

        System.out.println(countSubsetSum(a, 78));
        System.out.println(countSubsetSum(a, 29));

    }

    private boolean isSubsetSumMemoized(int[] arr, int sum) {
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        return isSubsetSumMemoizedUtil(arr, sum, 0, dp);
    }

    private boolean isSubsetSumMemoizedUtil(int[] arr, int sum, int i, Boolean[][] dp) {
        if (sum == 0) return true;
        if (i >= arr.length) return false;

        if (dp[i][sum] != null) return dp[i][sum];

        if (arr[i] <= sum && isSubsetSumMemoizedUtil(arr, sum - arr[i], i + 1, dp)) {
            dp[i][sum] = true;
            return true;
        }

        dp[i][sum] = isSubsetSumMemoizedUtil(arr, sum, i + 1, dp);
        return dp[i][sum];
    }

    private boolean isSubSetSumTabulation(int[] arr, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                if (dp[j - arr[i]] == 1)
                    dp[j] = 1;
            }
        }
        return dp[sum] == 1;
    }

    private static int countSubsetSum(int[] arr, int sum) {
        Integer[][] dp = new Integer[arr.length][sum + 1];
        return countSubsetSumUtil(arr, sum, 0, dp);
    }

    private static int countSubsetSumUtil(int[] arr, int sum, int idx, Integer[][] dp) {
        if (sum == 0) return 1;
        if (sum < 0 || idx >= arr.length) return 0;

        if (dp[idx][sum] == null) {
            int countIncluding = countSubsetSumUtil(arr, sum - arr[idx], idx + 1, dp);
            int countExcluding = countSubsetSumUtil(arr, sum, idx + 1, dp);
            dp[idx][sum] = countIncluding + countExcluding;
        }
        return dp[idx][sum];
    }
}
