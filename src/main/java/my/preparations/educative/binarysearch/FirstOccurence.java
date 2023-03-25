package my.preparations.educative.binarysearch;

/**
 * Problem statement#
 * Given a sorted array of integers and a target integer, find the first occurrence of the target and return its index. Return -1 if the target is not in the array.
 * <p>
 * Example#
 * Input:arr = [1, 3, 3, 3, 3, 6, 10, 10, 10, 100],target = 3
 * <p>
 * Output:1
 * <p>
 * Explanation: The first occurrence of 3 is at index 1.
 */
public class FirstOccurence {

    public static int find_first_occurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Find occurrence :" + find_first_occurrence(new int[]{1, 3, 3, 3, 3, 6, 10, 10, 10, 100}, 3));
        System.out.println("Find occurrence :" + find_first_occurrence(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1));
        System.out.println("Find occurrence :" + find_first_occurrence(new int[]{1, 22, 22, 33, 50, 100, 20000}, 33));
        System.out.println("Find occurrence :" + find_first_occurrence(new int[]{4, 6, 7, 7, 7, 20}, 8));
        System.out.println("Find occurrence :" + find_first_occurrence(new int[]{6, 7, 9, 10, 10, 10, 90}, 10));
        System.out.println("Find occurrence :" + find_first_occurrence(new int[]{4}, 4));
    }
}
