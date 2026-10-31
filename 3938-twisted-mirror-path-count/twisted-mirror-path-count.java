class Solution {
    public int mod = 1000000007;
    int[][][] dp;

    public int f(int[][] grid, int i, int j, int prevDir) {
        if (i >= grid.length || j >= grid[0].length)
            return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return 1;
        if (dp[i][j][prevDir] != -1)
            return dp[i][j][prevDir]  % mod;
        if (grid[i][j] == 1) {
            if (prevDir == 0) {
                return dp[i][j][prevDir] = (f(grid, i, j + 1, 1)) % mod;
            } else {
                return dp[i][j][prevDir] = f(grid, i + 1, j, 0)  % mod;
            }
        } else {
            int down = f(grid, i + 1, j, 0);
            int right = f(grid, i, j + 1, 1);
            return dp[i][j][prevDir] = (down + right)  % mod;
        }
    }

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][2];
        for (int[][] dp1 : dp) {
            for (int[] dp2 : dp1)
                Arrays.fill(dp2, -1);
        }
        return (f(grid, 0, 0, 0)) % mod;
    }
}