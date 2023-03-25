package my.preparations.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FourNumMatchingSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        return Collections.emptyList();

    }

    private void addQuadruplet(Set<List<Integer>> res, int a, int b, int c, int d) {
        res.add(Arrays.asList(new Integer[]{a, b, c, d}));
    }

    public static void main(String[] args) {
        FourNumMatchingSum s = new FourNumMatchingSum();
        int nums[] = new int[]{-2, -1, -1, 1, 1, 2, 2};
        System.out.println(s.fourSum(nums, 0));
    }
}
