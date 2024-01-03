package my.preparations.leetcode;

/**
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 * <p>
 * Train tickets are sold in three different ways:
 * <p>
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 * <p>
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 * <p>
 * Example:
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total, you spent $11 and covered all the days of your travel.
 */
public class _983_MinimunCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int minCost = Integer.MAX_VALUE;
        return traverse(days, 0, 0, costs, 0, minCost);
    }

    private int traverse(int[] days, int curIndex, int nextTicket, int[] costs, int curCost, int minCost) {
        if (curCost > minCost)
            return Integer.MAX_VALUE;
        if (curIndex >= days.length)
            return curCost;

        for (int i = curIndex; i < days.length; i++) {
            if (days[i] < curIndex)
                continue;
            for (int j = 0; j < costs.length; j++) {
                curCost += costs[j];
                int hop = j == 0 ? 1 : j == 1 ? 6 : 29;
                int nextIdx = days[i] + hop;
                int cost = traverse(days, i + 1, nextIdx, costs, curCost, minCost);
                minCost = Math.min(cost, minCost);
                curCost -= costs[j];
            }
        }
        return Math.min(curCost, minCost);
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20}, costs = new int[]{2, 7, 15};
        _983_MinimunCostTickets a = new _983_MinimunCostTickets();
        System.out.println(a.mincostTickets(days, costs));
    }
}
