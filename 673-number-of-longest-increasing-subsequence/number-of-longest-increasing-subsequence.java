class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(cnt , 1);
        Arrays.fill(dp, 1);
        int maxi = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && nums[i] > nums[j]) {
                    dp[i] = 1 + dp[j];
                    cnt[i] = cnt[j];
                } else if(dp[j] + 1 == dp[i] && nums[i] > nums[j]){
                    cnt[i] += cnt[j];
                }
                maxi = Math.max(maxi, dp[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxi)
                count += cnt[i];
        }
        return count;
    }
}