package my.preparations.educative.sliding_window;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 */
public class _2SmallestSubSetHavingSum {
    public static void main(String[] args) {
        System.out.println(findSmallestSubArrayWithSum(new int[]{2, 1, 5, 2, 3, 2}, 7));
        System.out.println(findSmallestSubArrayWithSum(new int[]{2, 1, 5, 2, 8}, 7));
        System.out.println(findSmallestSubArrayWithSum(new int[]{3, 4, 1, 1, 6}, 8));
    }

    public static int findSmallestSubArrayWithSum(int[] arr, int s) {
        int windowStart = 0, minSize = Integer.MAX_VALUE, windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] >= s) {
                minSize = 1;
                break;
            }
            windowSum += arr[windowEnd];
            if (windowSum >= s) {
                while (windowSum >= s) {
                    minSize = Math.min(minSize, windowEnd - windowStart + 1);
                    windowSum -= arr[windowStart];
                    windowStart++;
                }
            }
        }
        return minSize;
    }
}
