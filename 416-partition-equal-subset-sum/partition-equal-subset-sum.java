class Solution {
    public boolean f(int[] nums, int target, int idx, Boolean[][] dp) {
        if (idx == nums.length)
            return target == 0;
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (dp[idx][target] != null)
            return dp[idx][target];

        boolean take = f(nums, target - nums[idx], idx + 1, dp);
        boolean nottake = f(nums, target, idx + 1, dp);
        return dp[idx][target] = take || nottake;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[nums.length][sum];
        boolean[] used = new boolean[nums.length];
        return f(nums, sum / 2, 0, dp);
    }
}