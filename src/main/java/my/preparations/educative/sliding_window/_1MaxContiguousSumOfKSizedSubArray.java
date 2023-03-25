package my.preparations.educative.sliding_window;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * <p>
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class _1MaxContiguousSumOfKSizedSubArray {
    public static void main(String[] args) {
        int arr[] = {-1, 3, 9};
        int k = 1;

        System.out.print(maxContiguousSumOfKSize(arr, k));
    }

    private static int maxContiguousSumOfKSize(int[] arr, int k) {
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd > k - 1) {
                windowSum -= arr[windowStart];
                maxSum = Math.max(windowSum, maxSum);
                windowStart++;
            }
        }
        maxSum = Math.max(windowSum, maxSum);
        return maxSum;
    }
}
