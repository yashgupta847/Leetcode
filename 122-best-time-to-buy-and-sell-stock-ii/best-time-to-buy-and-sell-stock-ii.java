class Solution {
    public int f(int[] prices, int idx, int buy, int[][] dp) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][buy] != -1)
            return dp[idx][buy];
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(f(prices, idx + 1, 1, dp) - prices[idx], f(prices, idx + 1, 0, dp));
        } else {
            profit = Math.max(f(prices, idx + 1, 0, dp) + prices[idx], f(prices, idx + 1, 1, dp));
        }
        return dp[idx][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        // for (int[] dp1 : dp)
        //     Arrays.fill(dp1 , -1);
        // return f(prices, 0, 0, dp);
        dp[prices.length][0] = dp[prices.length][1] = 0;
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                // if (idx == prices.length)
                //     return 0;
                // if (dp[idx][buy] != -1)
                //     return dp[idx][buy];
                int profit = 0;
                if (buy == 0) {
                    profit = Math.max(dp[idx + 1][1] - prices[idx], dp[idx + 1][buy]);
                } else {
                    profit = Math.max(dp[idx + 1][0] + prices[idx], dp[idx + 1][buy]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][0];
    }
}