package my.preparations.educative.two_pointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * Example 2:
 * <p>
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * Example 3:
 * <p>
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int currDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (currDiff == 0) {
                    return targetSum;
                }

                if (Math.abs(currDiff) < smallestDiff ||
                    (Math.abs(currDiff) == Math.abs(smallestDiff) && currDiff > smallestDiff))
                    smallestDiff = currDiff;

                if (currDiff > 0) left++;
                else right--;
            }
        }
        return targetSum - smallestDiff;
    }
}
