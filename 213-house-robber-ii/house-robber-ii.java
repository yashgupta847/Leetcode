class Solution {

    public int f(int[] nums, int idx, int end, int[] dp) {
        if (idx >= end + 1)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int take = f(nums, idx + 2, end, dp) + nums[idx];
        int nottake = f(nums, idx + 1, end, dp);
        return dp[idx] = Math.max(take, nottake);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int one = f(nums, 0, nums.length - 2, dp);
        Arrays.fill(dp, -1);
        int two = f(nums, 1, nums.length - 1, dp);
        if(nums.length==1) return nums[0];
        return Math.max(one, two);
    }
}