class Solution {
    public int solve(int n , int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if(dp[n] != -1) return dp[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            ans += solve(left , dp) * solve(right , dp);
        }
        return dp[n] = ans;
    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n , dp);
    }
}