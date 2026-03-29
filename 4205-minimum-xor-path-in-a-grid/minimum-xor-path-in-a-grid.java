class Solution {
    int m, n;
    int[][] grid;
    Integer[][][] dp;

    public int f(int i, int j, int xor) {
        if (i >= m || j >= n)
            return Integer.MAX_VALUE;
        xor ^= grid[i][j];
        if (i == m - 1 && j == n - 1)
            return xor;
        if (dp[i][j][xor] != null)
            return dp[i][j][xor];
        int right = f(i, j + 1, xor);
        int down = f(i + 1, j, xor);
        return dp[i][j][xor] = Math.min(right, down);
    }

    public int minCost(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][1024];
        return f(0, 0, 0);
    }
}