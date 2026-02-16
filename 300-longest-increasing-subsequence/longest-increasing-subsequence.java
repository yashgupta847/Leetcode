class Solution {
    public int f(int[] nums, int idx, int prev, int[][] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];
        int len = f(nums, idx + 1, prev, dp); //notTake
        if (prev == -1 || (nums[idx] > nums[prev])) {
            len = Math.max(len, f(nums, idx + 1, idx, dp) + 1);
        }
        return dp[idx][prev + 1] = len;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        // for (int[] dp1 : dp)
        //     Arrays.fill(dp1, -1);
        // return f(nums, 0, -1, dp);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     max = Math.max(max, dp[i]);
        // }
        return max;
    }
}