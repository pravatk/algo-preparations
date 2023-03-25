package my.preparations.educative.two_pointers;

/**
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */
public class SortedSquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int start = 0, end = arr.length - 1, rL = 0, rH = arr.length - 1;

        while (start < end) {
            if (square(arr[start]) < square(arr[end])) {
                squares[rH--] = square(arr[end]);
                end--;
            } else {
                squares[rH--] = square(arr[start]);
                start++;
            }
        }
        return squares;
    }

    public static int square(int i) {
        return i * i;
    }
}

