class Solution {
    Long[][][] dp;

    public long solve(int grid[][], int col, int last1, int last2) {
        int n = grid.length;

        if (col >= n) {
            return 0;
        }

        if (dp[col][last1][last2] != null)
            return dp[col][last1][last2];

        long fromLast2 = 0;
        for (int i = 0; i < last2; i++) {
            fromLast2 += grid[i][col];
        }
        long ans = fromLast2 + solve(grid, col + 1, 0, last1);

        long sum = 0;
        if (col + 1 < n) {
            for (int i = last1; i < n; i++) {
                sum += grid[i][col];
                ans = Math.max(ans,
                        sum + solve(grid, col + 1, i + 1, 0));
            }
        }
        long temp = fromLast2;
        for (int i = 0; i < n; i++) {

            if (i < last2) {
                temp -= grid[i][col];
            }

            ans = Math.max(ans,
                    temp + solve(grid, col + 1, 0, i + 1));
        }

        return dp[col][last1][last2] = ans;
    }

    public long maximumScore(int[][] grid) {
        dp = new Long[grid.length + 1][grid.length + 1][grid.length + 1];
        return solve(grid, 0, 0, 0);
    }
}