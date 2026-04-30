class Solution {

    Integer[][][] dp;

    public int f(int[][] grid, int i, int j, int k, int n, int m) {

        if (i >= n || j >= m) return -Integer.MIN_VALUE;

        int cost = (grid[i][j] == 1 || grid[i][j] == 2) ? 1 : 0;
        int score = grid[i][j];

        if (k < cost) return -Integer.MIN_VALUE;

        if (i == n - 1 && j == m - 1) {
            return score;
        }

        if (dp[i][j][k] != null) return dp[i][j][k];

        int right = f(grid, i, j + 1, k - cost, n, m);
        int down  = f(grid, i + 1, j, k - cost, n, m);

        int best = Math.max(right, down);

        if (best < 0) return dp[i][j][k] = -Integer.MIN_VALUE;

        return dp[i][j][k] = score + best;
    }

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        dp = new Integer[n][m][k + 1];

        int ans = f(grid, 0, 0, k, n, m);
        return ans < 0 ? -1 : ans;
    }
}