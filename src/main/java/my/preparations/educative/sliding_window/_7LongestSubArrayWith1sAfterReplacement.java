package my.preparations.educative.sliding_window;

public class _7LongestSubArrayWith1sAfterReplacement {
    public static void main(String[] args) {
        System.out.println(findLongestSubArrayAfterReplacement(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(findLongestSubArrayAfterReplacement(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 1));
        System.out.println(findLongestSubArrayAfterReplacement(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1}, 3));
    }

    public static int findLongestSubArrayAfterReplacement(int[] arr, int k) {
        int windowStart = 0, max1sCount = 0, maxLength = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                max1sCount++;
            }
            int windowSize = windowEnd - windowStart + 1;
            while (windowSize - max1sCount > k) {
                if (arr[windowStart] == 1) max1sCount--;
                windowStart++;
                windowSize = windowEnd - windowStart + 1;
            }
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }
}
