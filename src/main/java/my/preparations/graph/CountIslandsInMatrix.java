package my.preparations.graph;

public class CountIslandsInMatrix {
    private static int countIslandsInMatrix(int[][] matrix, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    exploreIsland(matrix, i, j, visited, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static void exploreIsland(int[][] matrix, int i, int j, boolean[][] visited, int m, int n) {
        visited[i][j] = true;
        if (i - 1 >= 0 && matrix[i - 1][j] == 1 && !visited[i - 1][j])
            exploreIsland(matrix, i - 1, j, visited, m, n);
        if (i + 1 < m && matrix[i + 1][j] == 1 && !visited[i + 1][j])
            exploreIsland(matrix, i + 1, j, visited, m, n);
        if (j - 1 >= 0 && matrix[i][j - 1] == 1 && !visited[i][j - 1])
            exploreIsland(matrix, i, j - 1, visited, m, n);
        if (j + 1 < n && matrix[i][j + 1] == 1 && !visited[i][j + 1])
            exploreIsland(matrix, i, j + 1, visited, m, n);
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0, 1, 0}, {1, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}, {0, 1, 0, 1, 1, 0}, {0, 0, 0, 0, 0, 0}};
        System.out.println(countIslandsInMatrix(matrix, 6, 6));
    }

}
