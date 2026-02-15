class Solution {
    public int f(int[] nums, int idx, int canTake, int last , int[][] dp) {
        if (idx == last)
            return 0;
        if(dp[idx][canTake] != -1) return dp[idx][canTake];
        if (canTake == 1) {
            return dp[idx][canTake] = Math.max(f(nums, idx + 1, 0, last , dp) + nums[idx], f(nums, idx + 1, 1, last , dp));
        } else {
            return dp[idx][canTake] =  f(nums, idx + 1, 1, last , dp);
        }
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int[][] dp2 = new int[nums.length][2];
        for(int[] dp1 : dp) Arrays.fill(dp1 , -1);
        for(int[] dp1 : dp2) Arrays.fill(dp1 , -1);
        if(nums.length == 1) return nums[0];
        return Math.max(f(nums, 0, 1, nums.length - 1 , dp), f(nums, 1, 1, nums.length , dp2));
    }
}