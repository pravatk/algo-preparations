package my.preparations.educative.two_pointers;

import java.util.Arrays;

/**
 * Problem Statement#
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 * <p>
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletSumLessThanTarget {
    public static int searchTriplets(int[] arr, int target) {
        int count = -1;
        boolean isFound = false;
        if (arr == null || arr.length == 0) return -1;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int diff = target - arr[i] - arr[left] - arr[right];
                if (diff > 0) {
                    isFound = true;
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return isFound ? count + 1 : count;
    }
}
