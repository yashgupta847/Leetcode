class Solution {
    int[] dp;
    public int f(int[] nums, int t) {
        if (t == 0) return 1;
        if (t < 0) return 0;
        if (dp[t] != -1) return dp[t];

        int ways = 0;
        for (int x : nums) {
            ways += f(nums, t - x);
        }
        return dp[t] = ways;
    }

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return f(nums, target);
    }
}
