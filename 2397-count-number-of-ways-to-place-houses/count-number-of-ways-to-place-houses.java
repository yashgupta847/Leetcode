class Solution {
    public final long mod = 1_000_000_007;

    public long f(int n, long[] dp) {
        if (n == 0)
            return 1;

        if (n == 1) {
            return 2;
        }
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = (f(n - 1, dp) + f(n - 2, dp)) % mod;
    }

    public int countHousePlacements(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        long ans = f(n, dp);
        return (int) ((ans * ans) % mod);
    }
}