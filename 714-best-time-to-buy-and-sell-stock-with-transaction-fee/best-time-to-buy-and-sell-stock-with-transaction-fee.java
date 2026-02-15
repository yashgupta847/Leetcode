class Solution {
    public int f(int[] prices, int idx, int canBuy, int f, int[][] dp) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][canBuy] != -1)
            return dp[idx][canBuy];
        if (canBuy == 1) {
            return dp[idx][canBuy] = Math.max(f(prices, idx + 1, 0, f, dp) - prices[idx], f(prices, idx + 1, 1, f, dp));
        } else
            return dp[idx][canBuy] = Math.max(f(prices, idx + 1, 1, f, dp) + prices[idx] - f,
                    f(prices, idx + 1, 0, f, dp));
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(prices, 0, 1, fee, dp);
    }
}