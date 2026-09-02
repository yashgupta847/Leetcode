class Solution {
    public int f(int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxi = Integer.MAX_VALUE;
        for (int start = i; start <= j; start++) {
            maxi = Math.min(maxi, start + Math.max(f(i, start - 1, dp), f(start + 1, j, dp)));
        }
        return dp[i][j] = maxi;
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(1, n, dp);
    }
}