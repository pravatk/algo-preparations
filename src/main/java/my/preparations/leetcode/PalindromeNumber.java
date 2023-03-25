package my.preparations.leetcode;

import java.util.concurrent.Flow;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return reverse(x) == x;
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(123));
    }
}
