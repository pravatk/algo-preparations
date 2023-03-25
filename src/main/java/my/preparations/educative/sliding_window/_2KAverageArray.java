package my.preparations.educative.sliding_window;

import my.preparations.utils.PrintUtils;

public class _2KAverageArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        PrintUtils.printArray(calculateKAverage(arr, K));
    }

    private static Double[] calculateKAverage(int[] arr, int k) {
        Double[] average = new Double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                average[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return average;
    }
}
