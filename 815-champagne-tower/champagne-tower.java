class Solution {
    double[][] dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[query_row + 1][query_row + 1];
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= query_row; j++) {
                dp[i][j] = -1.0;
            }
        }
        double ans = solve(query_row, query_glass, poured);
        return Math.min(1.0, ans);
    }
    private double solve(int i, int j, int poured) {
        if (j < 0 || j > i) return 0.0;
        if (i == 0 && j == 0) return poured;
        if (dp[i][j] != -1.0) return dp[i][j];
        double left = Math.max(0.0, solve(i - 1, j - 1, poured) - 1.0) / 2.0;
        double right = Math.max(0.0, solve(i - 1, j, poured) - 1.0) / 2.0;
        return dp[i][j] = left + right;
    }
}
