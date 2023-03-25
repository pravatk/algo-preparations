package my.preparations.leetcode;

public class LongestPalindromeSubstring {
    public String getLongestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCentre(s, i, i);
            int len2 = expandAroundCentre(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCentre(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0
                && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring l = new LongestPalindromeSubstring();
        System.out.println(l.getLongestPalindrome("abcdcbfgagfbcd"));
    }
}
