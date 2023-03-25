package my.preparations.educative.two_pointers;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * Example 2:
 * <p>
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * Example 3:
 * <p>
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * Example 4:
 * <p>
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 */
public class MinLengthUnsortedArray {

    public static int sort(int[] arr) {
        int left = 0, right = arr.length - 1, minSoFar = Integer.MAX_VALUE, maxSoFar = Integer.MIN_VALUE;

        while (left <= right - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        if (left == arr.length - 1) return 0;

        while (right >= left && arr[right] > arr[right - 1]) {
            right--;
        }

        for (int i = left; i <= right; i++) {
            minSoFar = Math.min(arr[i], minSoFar);
            maxSoFar = Math.max(arr[i], maxSoFar);
        }

        while (left > 0 && arr[left - 1] >= minSoFar)
            left--;
        while (right < arr.length - 1 && arr[right + 1] <= maxSoFar)
            right++;
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(sort(new int[]{1, 2, 3}));
        System.out.println(sort(new int[]{3, 2, 1}));
    }
}
