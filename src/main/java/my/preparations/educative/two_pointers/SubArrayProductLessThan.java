package my.preparations.educative.two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement#
 * Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * Example 2:
 * <p>
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
public class SubArrayProductLessThan {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int product = 1;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            product *= arr[end];

            while (product >= target && start < end) {
                product /= arr[start++];
            }

            List<Integer> sol = new ArrayList<>();
            for (int i = end; i >= start; i--) {
                sol.add(arr[i]);
                subarrays.add(new ArrayList<>(sol));
            }
        }
        return subarrays;
    }
}
