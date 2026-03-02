class Solution {
    public int f(int[][] obstacleGrid, int i, int j, int n, int m, int[][] dp) {
        if (i > n || j > m)
            return 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        if (i == n && j == m) {
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = f(obstacleGrid, i + 1, j, n, m, dp);
        int right = f(obstacleGrid, i, j + 1, n, m, dp);
        return dp[i][j] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] dp1 : dp) {
            Arrays.fill(dp1, -1);
        }
        return f(obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1, dp);
    }
}