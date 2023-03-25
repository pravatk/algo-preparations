package my.preparations.dp;

public class MinCostMatrix {
    private int[][] minCost;

    public MinCostMatrix(int m, int n) {
        minCost = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                minCost[i][j] = Integer.MAX_VALUE;
    }

    public int minCost(int[][] arr, int i, int j) {
        if (i == 0 && j == 0) minCost[i][j] = arr[i][j];
        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0) return Integer.MAX_VALUE;

        if (minCost[i][j] == Integer.MAX_VALUE) {
            minCost[i][j] = arr[i][j] + Math.min(minCost(arr, i, j - 1),
                    Math.min(minCost(arr, i - 1, j), minCost(arr, i - 1, j - 1)));
        }
        return minCost[i][j];
    }

    public static void main(String args[]) {
        MinCostMatrix m = new MinCostMatrix(3, 3);
        int arr[][] = new int[][]{{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int cost = m.minCost(arr, 2, 2);
        System.out.println(cost);
    }
}
