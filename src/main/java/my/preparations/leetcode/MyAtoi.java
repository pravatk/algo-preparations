package my.preparations.leetcode;

public class MyAtoi {
    public int myAtoi(String s) {
        int res = 0;
        boolean isNegative = false;
        for (char ch : s.trim().toCharArray()) {
            if (ch == '-') {
                isNegative = true;
                continue;
            }
            if (!isNumber(ch))
                break;
            else {
                if ((isNegative && Long.valueOf(-res * 10) < Integer.MIN_VALUE)) {
                    return Integer.MIN_VALUE;

                }

                if (Long.valueOf(res * 10) > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                res = res * 10 + Integer.parseInt(String.valueOf(ch));
            }
        }

        return isNegative ? -res : res;
    }

    public boolean isNumber(char ch) {
        try {
            Integer.parseInt(String.valueOf(ch));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("46757867898908907"));
    }
}
