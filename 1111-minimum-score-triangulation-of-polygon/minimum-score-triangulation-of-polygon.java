class Solution {
    public int solve(int i, int j, int[] values) {
        if (i + 1 == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, values[i] * values[j] * values[k] + solve(i, k, values) + solve(k, j, values));
        }
        return ans;
    }

    public int solveMemo(int i, int j, int[] values , int[][] dp) {
        if (i + 1 == j) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, values[i] * values[j] * values[k] + solveMemo(i, k, values, dp) + solveMemo(k, j, values , dp));
        }
        return dp[i][j] =  ans;
    }

    public int minScoreTriangulation(int[] values) {
        int mini = Integer.MAX_VALUE;
        int i = 0;
        int j = values.length - 1;
        int[][] dp = new int[values.length][values.length];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        mini = solveMemo(i, j, values ,  dp);

        return mini;
    }
}