class Solution {
    public int f(int[] prices, int idx, int buy, int[][][] dp, int cap) {
        if (cap == 0)
            return 0;
        if (idx == prices.length)
            return 0;
        if (dp[idx][buy][cap] != -1)
            return dp[idx][buy][cap];
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(f(prices, idx + 1, 1, dp, cap) - prices[idx], f(prices, idx + 1, 0, dp, cap));
        } else {
            profit = Math.max(f(prices, idx + 1, 0, dp, cap - 1) + prices[idx], f(prices, idx + 1, 1, dp, cap));
        }
        return dp[idx][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        for (int[][] dp1 : dp)
            for (int[] dp2 : dp1)
                Arrays.fill(dp2, -1);
        return f(prices, 0, 0, dp, 2);
        // dp[prices.length][0] = dp[prices.length][1] = 0;
        // for (int idx = prices.length - 1; idx >= 0; idx--) {
        //     for (int buy = 0; buy <= 1; buy++) {
        //         // if (idx == prices.length)
        //         //     return 0;
        //         // if (dp[idx][buy] != -1)
        //         //     return dp[idx][buy];
        //         int profit = 0;
        //         if (buy == 0) {
        //             profit = Math.max(dp[idx + 1][1] - prices[idx], dp[idx + 1][buy]);
        //         } else {
        //             profit = Math.max(dp[idx + 1][0] + prices[idx], dp[idx + 1][buy]);
        //         }
        //         dp[idx][buy] = profit;
        //     }
        // }
        // return dp[0][0];
    }
}