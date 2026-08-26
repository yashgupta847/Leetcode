class Solution {
    // public int ans = 0;
    public int MOD = 1_000_000_007;

    public int f(int i, int sum, int target, int k, int n, int[][] dp) {
        if (i == n) {

            return sum == target ? 1 : 0;
        }

        if (dp[i][sum] != -1)
            return dp[i][sum];
        int ways = 0;
        for (int j = 1; j <= k; j++) {
            if (sum + j <= target) {
                ways = (int) ((ways + (long) f(
                        i + 1,
                        sum + j,
                        target,
                        k,
                        n,
                        dp)) % MOD);
            }
        }
        return dp[i][sum] = ways;

    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(0, 0, target, k, n, dp);
        // return ans;
    }
}