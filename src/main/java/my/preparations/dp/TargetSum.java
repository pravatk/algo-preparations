package my.preparations.dp;

import java.util.*;

/**
 * Given a target and an array of numbers, return true if the target can be achieved by summing numbers from array.
 * Constraints:
 * 1. All numbers are non-negative
 * 2. Any number can be used multiple times
 */
public class TargetSum {
    private static boolean canSumRecursive(int target, int[] numbers) {
        if (target == 0) return true;
        if (target < 0) return false;
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            result = canSumRecursive(target - numbers[i], numbers);
            if (result) return true;
        }
        return false;
    }

    private static boolean canSumDP(int target, int[] numbers) {
        Map<Integer, Boolean> dp = new HashMap<>();
        return canSumDPUtil(target, numbers, dp);
    }

    private static boolean canSumDPUtil(int target, int[] numbers, Map<Integer, Boolean> dp) {
        if (dp.containsKey(target)) return dp.get(target);

        if (target == 0) return true;
        if (target < 0) return false;
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            result = canSumDPUtil(target - numbers[i], numbers, dp);
            dp.put(target, result);
            if (result) return true;
        }
        return dp.get(target);

    }

    private static List<Integer> howSumDP(int target, int[] numbers) {
        Map<Integer, Boolean> dp = new HashMap<>();
        List<Integer> probableSol = new ArrayList<>();
        howSumDPUtil(target, numbers, dp, probableSol);
        return probableSol;
    }

    private static boolean howSumDPUtil(int target, int[] numbers, Map<Integer, Boolean> dp, List<Integer> probableSol) {
        if (dp.containsKey(target)) return dp.get(target);

        if (target == 0) return true;
        if (target < 0) return false;
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            result = howSumDPUtil(target - numbers[i], numbers, dp, probableSol);
            dp.put(target, result);
            if (result) {
                probableSol.add(numbers[i]);
                return result;
            }
        }
        return dp.get(target);
    }

    private static List<Integer> bestSum(int target, int[] numbers) {
        Map<Integer, List<Integer>> dp = new HashMap<>();
        return bestSumDPUtil(target, numbers, dp);
    }

    private static List<Integer> bestSumDPUtil(int target, int[] numbers, Map<Integer, List<Integer>> dp) {
        if (dp.containsKey(target))
            return dp.get(target);

        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        List<Integer> shortest = null;
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> candidate = bestSumDPUtil(target - numbers[i], numbers, dp);
            if (candidate != null) {
                List<Integer> combination = new ArrayList<>();
                combination.addAll(candidate);
                combination.add(numbers[i]);
                if (shortest == null || shortest.size() > combination.size()) {
                    shortest = combination;
                }
            }
        }

        dp.put(target, shortest);

        return shortest;
    }

    public static void main(String[] args) {
//        System.out.println(canSumRecursive(7, new int[]{2, 4, 3, 7}));
//        System.out.println(canSumRecursive(7, new int[]{2, 4}));
////        System.out.println(canSumRecursive(300, new int[]{7, 14}));
//
//        System.out.println(canSumDP(7, new int[]{2, 4, 3, 7}));
//        System.out.println(canSumDP(7, new int[]{2, 4}));
//        System.out.println(canSumDP(300, new int[]{7, 14}));
//
//        System.out.println(howSumDP(7, new int[]{2, 4, 3, 7}));
//        System.out.println(howSumDP(7, new int[]{2, 4}));
//        System.out.println(howSumDP(300, new int[]{7, 14}));

        System.out.println(bestSum(7, new int[]{2, 4, 3, 7}));
        System.out.println(bestSum(7, new int[]{2, 4}));
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}));
        System.out.println(bestSum(308, new int[]{1, 2, 5, 25}));

    }
}
