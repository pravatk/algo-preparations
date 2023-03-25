package my.preparations.educative.fast_slow_pointer;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean findWithAdditionalSpace(int num) {
        Set<Integer> visitedNodes = new HashSet<>();
        int n = num;
        while (!visitedNodes.contains(n)) {
            visitedNodes.add(n);
            if (n == 1)
                return true;
            n = squaredSum(n);
        }
        return false;
    }

    private static int squaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = squaredSum(slow);
            fast = squaredSum(squaredSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        System.out.println(findWithAdditionalSpace(23));
        System.out.println(findWithAdditionalSpace(12));
        System.out.println(find(23));
        System.out.println(find(12));
    }
}
