package my.preparations.educative.two_pointers;

/**
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithSum {
    public static int[] search(int[] arr, int targetSum) {
        int start = 0, end = arr.length - 1, currentSum = 0;
        boolean found = false;
        while (start < end) {
            currentSum = arr[start] + arr[end];
            if (currentSum > targetSum)
                end--;
            else if (currentSum < targetSum)
                start++;
            else {
                found = true;
                break;
            }
        }
        return found ? new int[]{start, end} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
