class Solution {
    Boolean[] dp;
    public boolean f(int[] nums, int idx) {
        if (idx == nums.length - 1)
            return true;
        if (idx >= nums.length)
            return false;
        if(dp[idx] != null) return dp[idx];
        for (int i = 1; i <= nums[idx]; i++) {
            boolean ans = f(nums, idx + i);
            if(ans) return true;
        }
        return dp[idx] = false;
    }
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return f(nums, 0);
    }
}