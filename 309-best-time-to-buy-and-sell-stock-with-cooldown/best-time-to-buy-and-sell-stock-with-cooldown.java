class Solution {
    public int f(int[] prices, int idx, int canBuy, int[][] dp) {
        if (idx >= prices.length)
            return 0;
        if (dp[idx][canBuy] != -1)
            return dp[idx][canBuy];

        if (canBuy == 1) {
            return dp[idx][canBuy] = Math.max(f(prices, idx + 1, 0 , dp) - prices[idx], f(prices, idx + 1, 1 , dp));
        } else {
            return dp[idx][canBuy] = Math.max(f(prices, idx + 2, 1 , dp) + prices[idx], f(prices, idx + 1, 0 , dp));
        }

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(prices, 0, 1, dp);
    }
}