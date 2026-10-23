class Solution {
    int[] dp;
    public int f(int[] cost, int idx) {
        if (idx == cost.length) {
            return 0;
        }
        if (idx > cost.length)
            return Integer.MAX_VALUE;
        if (dp[idx] != -1)
            return dp[idx];
        int charge1 = f(cost, idx + 1);
        int charge2 = f(cost, idx + 2);
        if (charge1 != Integer.MAX_VALUE)
            charge1 += cost[idx];
        if (charge2 != Integer.MAX_VALUE)
            charge2 += cost[idx];
        return dp[idx] = Math.min(charge1, charge2);
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp , -1);
        return Math.min(f(cost, 0), f(cost, 1));
    }
}