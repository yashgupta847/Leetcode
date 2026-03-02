class Solution {
    public boolean f(int t, int[] nums, int i, Boolean[][] dp) {
        if (i == 0) {
            if (nums[0] == t)
                return true;
            return false;
        }
        if (dp[i][t] != null)
            return dp[i][t];
        if (t == 0)
            return true;
        boolean notTake = f(t, nums, i - 1, dp);
        boolean take = false;
        if (nums[i] <= t) {
            take = f(t - nums[i], nums, i - 1, dp);
        }
        return dp[i][t] = take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++)
            total += nums[i];
        if (total % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[nums.length][total / 2 + 1];
        return f(total / 2, nums, nums.length - 1, dp);
    }
}