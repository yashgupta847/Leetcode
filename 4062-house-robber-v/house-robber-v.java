class Solution {
    public long f(int[] nums, int[] colors, int prevtaken, int idx , long[][] dp) {
        if (idx == nums.length)
            return 0;
        if(dp[idx][prevtaken] != -1) return dp[idx][prevtaken];
        long skip = f(nums, colors, 0, idx + 1 , dp);
        boolean take = true;
        if (idx > 0 && prevtaken == 1 && colors[idx] == colors[idx - 1])
            take = false;
        long taken = 0;
        if (take) {
            taken = f(nums, colors, 1, idx + 1 , dp) + nums[idx];
        }
        return dp[idx][prevtaken] = Math.max(taken, skip);

    }

    public long rob(int[] nums, int[] colors) {
        long[][] dp = new long[nums.length][2];
        for (long[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(nums, colors, 0, 0 , dp);
    }
}