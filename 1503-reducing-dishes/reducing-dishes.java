class Solution {
    public int f(int[] s, int idx, int currT, int[][] dp) {

        if (idx == s.length) {
            return 0;
        }
        if (dp[idx][currT] != -1)
            return dp[idx][currT];
        int take = f(s, idx + 1, currT + 1, dp) + currT * (s[idx]);
        int notTake = f(s, idx + 1, currT, dp);
        return dp[idx][currT] = Math.max(take, notTake);
    }

    public int fTab(int[] s) {
        int[][] dp = new int[s.length + 1][s.length + 1];
        for (int idx = s.length - 1; idx >= 0; idx--) {
            for (int time = idx; time >= 0; time--) {
                int take = dp[idx+1][time+1] + (time+1) * (s[idx]);
                int notTake = dp[idx+1][time];
                dp[idx][time] = Math.max(take , notTake);
            }
        }
        return dp[0][0];
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length + 1];
        for (int[] dp1 : dp) {
            Arrays.fill(dp1, -1);
        }

        // return f(satisfaction, 0, 1, dp);
        return fTab(satisfaction);
    }
}