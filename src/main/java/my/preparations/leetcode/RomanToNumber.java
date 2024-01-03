package my.preparations.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class RomanToNumber {
    static Map<String, Integer> valueMap;

    static {
        valueMap = new HashMap<>();
        valueMap.put("M", 1000);
        valueMap.put("CM", 900);
        valueMap.put("D", 500);
        valueMap.put("CD", 400);
        valueMap.put("C", 100);
        valueMap.put("XC", 90);
        valueMap.put("L", 50);
        valueMap.put("XL", 40);
        valueMap.put("X", 10);
        valueMap.put("IX", 9);
        valueMap.put("V", 5);
        valueMap.put("IV", 4);
        valueMap.put("I", 1);
    }

    public static int romanToInt(String s) {
        int val = 0;
        Stack<String> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'I' || ch == 'C' || ch == 'X') {
                if (!stack.isEmpty()) {
                    // Consecutive chars
                    String prev = stack.pop();
                    val += valueMap.getOrDefault(prev + ch, valueMap.get(prev));
                    if (valueMap.containsKey(prev + ch)) continue;
                }
                stack.push(String.valueOf(ch));
            } else {
                if (stack.isEmpty())
                    val += valueMap.get(String.valueOf(ch));
                else {
                    String prev = stack.pop();
                    val += valueMap.getOrDefault(prev + ch, valueMap.get(prev) + valueMap.get(String.valueOf(ch)));
                }
            }
        }
        return stack.isEmpty() ? val : val + valueMap.get(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
