class Solution {
    public int sum;

    public int f(int[] nums, int target, int idx, int[][] dp) {
        if (idx == nums.length)
            return target == 0 ? 1 : 0;
        if (target < -sum || target > sum)
            return 0;

        int shiftedTarget = target + sum;

        if (dp[idx][shiftedTarget] != -1)
            return dp[idx][shiftedTarget];
        int minus = f(nums, target - nums[idx], idx + 1, dp);
        int plus = f(nums, target + nums[idx], idx + 1, dp);
        return dp[idx][shiftedTarget] = minus + plus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(nums, target, 0, dp);
    }
}