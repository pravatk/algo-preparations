package my.preparations.leetcode;

import java.util.*;

public class _554_brick_wall {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 2, 1));
        input.add(Arrays.asList(3, 1, 2));
        input.add(Arrays.asList(1, 3, 2));
        input.add(Arrays.asList(2, 4));
        input.add(Arrays.asList(3, 1, 2));
        input.add(Arrays.asList(1, 3, 1, 1));

        System.out.println(leastBricks(input));
    }

    private static int leastBricks(List<List<Integer>> input) {
        int maxGap = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (List<Integer> l : input) {
            int prev = 0;
            for (int c = 0; c < l.size() - 1; c++) {
                int i = l.get(c);
                m.put(prev + i, m.getOrDefault(prev + i, 0) + 1);
                prev += i;
                maxGap = Math.max(maxGap, m.get(prev));
            }
        }

        return input.size() - maxGap;
    }
}
