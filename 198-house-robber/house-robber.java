class Solution {
    public int f(int[] nums, int idx, int canTake, int[][] dp) {
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx][canTake] != -1)
            return dp[idx][canTake];
        if (canTake == 1) {
            return dp[idx][canTake] = Math.max(f(nums, idx + 1, 0 , dp) + nums[idx], f(nums, idx + 1, 1 , dp));
        } else {
            return dp[idx][canTake] = f(nums, idx + 1, 1 , dp);
        }
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(nums, 0, 1, dp);
    }
}