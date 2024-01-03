package my.preparations.educative.array;

import java.util.Arrays;

/**
 * Given an unsorted array, the maximum sum sub-array is the sub-array (contiguous elements) from
 * for which the sum of the elements is maximum. In this challenge, we want to find the sum of the
 * maximum sum sub-array. This problem is a tricky one because the array might have negative integers
 * in any position, so we have to cater to those negative integers while choosing the contiguous
 * subarray with the largest positive values.
 * <p>
 * Sample Input
 * arr = {1, 7, -2, -5, 10, -1}
 * Sample Output
 * 11
 */
public class ContiguousMaxSumSubarray {
    public static int findMaxSumSubArrayBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int findMaxSumSubArray(int[] arr) {
        int currSum = arr[0], globalSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = arr[i];
            } else {
                currSum += arr[i];
            }
            globalSum = Math.max(globalSum, currSum);
        }
        return globalSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArrayBruteForce(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }
}
