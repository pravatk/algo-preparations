package my.preparations.educative.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Quadruple Sum to Target (medium)#
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 * whose sum is equal to the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * Example 2:
 * <p>
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSum {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int low = j + 1, high = arr.length - 1;
                while (low < high) {
                    int diff = target - arr[i] - arr[j] - arr[low] - arr[high];
                    if (diff == 0) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(arr[i]);
                        sol.add(arr[j]);
                        sol.add(arr[low]);
                        sol.add(arr[high]);
                        quadruplets.add(sol);
                        low++;
                        high--;
                        while (low < arr.length - 1 && arr[low] == arr[low + 1])
                            low++;
                        while (high > low && high < arr.length - 1 && arr[high] == arr[high - 1])
                            high--;
                    } else if (diff > 0) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return quadruplets;
    }
}
