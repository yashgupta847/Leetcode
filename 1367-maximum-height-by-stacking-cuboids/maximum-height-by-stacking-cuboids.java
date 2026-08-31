class Solution {
    public int solve(int[][] c, int idx, int prev, int[][] dp) {
        if (idx == c.length)
            return 0;
        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];
        int take = 0;
        if (prev == -1 || (c[prev][0] <= c[idx][0] && c[prev][1] <= c[idx][1] && c[prev][2] <= c[idx][2])) {
            take = c[idx][2] + solve(c, idx + 1, idx, dp);
        }
        int nottake = solve(c, idx + 1, prev, dp);
        return dp[idx][prev + 1] = Math.max(take, nottake);
    }

    public int maxHeight(int[][] c) {
        int[][] dp = new int[c.length][c.length + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        for (int i = 0; i < c.length; i++) {
            Arrays.sort(c[i]);
        }
        Arrays.sort(c, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];
        });
        return solve(c, 0, -1, dp);
    }
}