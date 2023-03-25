package my.preparations.educative.two_pointers;

/**
 * Problem Statement#
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * <p>
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 * Example 2:
 * <p>
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0, 0, 1, 2, 2, 2,]
 */
public class DutchFlag {
    public static void sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, low, i);
                low++;
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
