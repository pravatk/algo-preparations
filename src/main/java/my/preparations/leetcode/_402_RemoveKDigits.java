package my.preparations.leetcode;

import java.util.Stack;

public class _402_RemoveKDigits {

    public static void main(String[] args) {
        _402_RemoveKDigits s = new _402_RemoveKDigits();
        String n = "12345";
        System.out.println(s.removeKDigits(n, 1));
        System.out.println(s.removeKDigits(n, 2));

        System.out.println(s.removeKDigits("1432219", 3));
        System.out.println(s.removeKDigits("10200", 1));
    }

    public String removeKDigits(String num, int k) {
        if (num.length() <= k)
            return "0";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            while (!s.isEmpty() && k > 0 && s.peek() > cur) {
                s.pop();
                k--;
            }
            s.push(cur);
        }
        while (!s.isEmpty() && k > 0) {
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty())
            sb.append(s.pop());

        return removeLeadingZero(sb.reverse().toString());
    }

    private String removeLeadingZero(String s) {
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) == '0')
            idx++;
        return s.substring(idx);
    }
}
