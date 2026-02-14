class Solution {
    public int f(int[][] grid, int i, int j, int[][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = f(grid, i + 1, j , dp);
        int right = f(grid, i, j + 1 , dp);
        return dp[i][j] = Math.min(down, right) + grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] dp1 : dp) Arrays.fill(dp1 , -1);
        return f(grid, 0, 0, dp);
    }
}