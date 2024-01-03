package my.preparations.leetcode;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 * <p>
 * - Integers in each row are sorted in ascending from left to right.
 * - Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * <p>
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 */
public class _240_SearchInMatrixII {

    public boolean searchMatrixOptimized(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (col >= 0 && row < matrix.length) {
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col])
                row++;
            else
                return true;
        }
        return false;
    }

    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            boolean isFound = binarySearch(ints, target);
            if (isFound)
                return true;
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[low] > target || arr[high] < target)
            return false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        _240_SearchInMatrixII sol = new _240_SearchInMatrixII();
        System.out.println(sol.searchMatrixBinarySearch(input, 5));
        System.out.println(sol.searchMatrixBinarySearch(input, 20));

        System.out.println(sol.searchMatrixOptimized(input, 5));
        System.out.println(sol.searchMatrixOptimized(input, 21));
    }

}
