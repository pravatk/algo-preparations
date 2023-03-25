package my.preparations.leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        Long y = 0L;
        boolean isNegative = x < 0;
        if (isNegative) x = -x;

        while (x % 10 > 0 || x > 0) {
            y = (y * 10) + (x % 10);
            x = x / 10;
        }
        if (y > Integer.MAX_VALUE) return 0;
        if (isNegative)
            return -y.intValue();
        return y.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
