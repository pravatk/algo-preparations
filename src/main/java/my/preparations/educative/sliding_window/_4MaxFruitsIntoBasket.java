package my.preparations.educative.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
 * <p>
 * You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * <p>
 * Write a function to return the maximum number of fruits in both baskets.
 * <p>
 * Example 1:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * Example 2:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class _4MaxFruitsIntoBasket {
    static int NUM_BASKETS = 3;

    public static void main(String[] args) {
        char[] fruits = {'A', 'B', 'C', 'A', 'C', 'D'};
        System.out.println(findMaxFruitsToPutInBasket(fruits));
        System.out.println(findMaxFruitsToPutInBasket(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    private static int findMaxFruitsToPutInBasket(char[] fruits) {
        int maxFruit = Integer.MIN_VALUE;
        int windowStart = 0;
        Set<Character> uniqueFruits = new HashSet<>();
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            uniqueFruits.add(fruits[windowEnd]);// Add the fruit
            if (uniqueFruits.size() <= NUM_BASKETS) {
                maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
            } else {
                while (uniqueFruits.size() > NUM_BASKETS) {
                    uniqueFruits.remove(fruits[windowStart]);
                    windowStart++;
                }
                maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
            }
        }
        return maxFruit;
    }
}
