package my.preparations.leetcode;

public class _74_SearchIn2DMatrix {
    public static void main(String[] args) {
        _74_SearchIn2DMatrix s = new _74_SearchIn2DMatrix();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(s.searchMatrix(matrix, 3));
        System.out.println(s.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int row = 0;
        while (row < m) {
            int i = 0, j = n - 1;

            if (matrix[row][j] >= target) {
                // Perform Binary Search
                if (matrix[row][j] == target) return true;
                while (i < j) {
                    int mid = (i + j) / 2;
                    if (matrix[row][mid] == target)
                        return true;
                    else if (matrix[row][mid] > target)
                        j = mid;
                    else
                        i = mid + 1;
                }
            }
            row++;

        }
        return false;
    }
}
