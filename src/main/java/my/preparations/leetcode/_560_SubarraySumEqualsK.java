package my.preparations.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _560_SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 1, 1, 1, 1};
        int k = 3;
        System.out.println(subarraySumBruteForce(nums, k));
        System.out.println(subarraySum(nums, k));
    }

    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int diff = sum - k;
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    private static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        List<String> solutions = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                    solutions.add(i + " " + j);
                }
            }
        }
        System.out.println(solutions);
        return count;
    }
}
