class Solution {

    public int f(int target, int[] coins, int idx, int[][] dp) {
        if (idx == coins.length)
            return target == 0 ? 1 : 0;
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        if (dp[idx][target] != -1)
            return dp[idx][target];
        int take = f(target - coins[idx], coins, idx , dp);
        int nottake = f(target, coins, idx + 1 , dp);
        return dp[idx][target] = take + nottake;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(amount, coins, 0, dp);
    }
}