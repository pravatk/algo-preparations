package my.preparations.educative.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Ex {
    public static int balanceSum(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int leftSum = arr.get(low), rightSum = arr.get(high);
        int pivotIndex = 0;
        while (low != high) {
            if (leftSum > rightSum) {
                high--;
                rightSum += arr.get(high);
            } else if (leftSum < rightSum) {
                low++;
                leftSum += arr.get(low);
            } else if (low != high) {
                low++;
                leftSum += arr.get(low);
            } else {
                pivotIndex = low;
                break;
            }
        }
        return low;
    }

    public static int getMaxDeletions(String s) {
        int toDelete = 0;
        Stack<Character> upDownStack = new Stack<>();
        Stack<Character> leftRightStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case 'U':
                case 'D':
                    if (!upDownStack.isEmpty() && !upDownStack.peek().equals(current)) {
                        upDownStack.pop();
                        toDelete += 2;
                    } else {
                        upDownStack.push(current);
                    }
                    break;
                case 'L':
                case 'R':
                    if (!leftRightStack.isEmpty() && !leftRightStack.peek().equals(current)) {
                        leftRightStack.pop();
                        toDelete += 2;
                    } else {
                        leftRightStack.push(current);
                    }
                    break;
                default:
                    break;
            }
        }
        return toDelete;
    }

    public static void main(String[] args) {
        System.out.println(balanceSum(Arrays.asList(1, 2, 3, 25, 1, 12, 7, 6, 6)));
        System.out.println(balanceSum(Arrays.asList(1, 2, 3, 3)));
//        System.out.println(getMaxDeletions("RRR"));
    }
}
