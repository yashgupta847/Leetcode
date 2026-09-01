class Solution {
    public int solve(int idx, int diff, int[] nums, Map<Integer, Integer>[] dp) {
        if (idx == nums.length)
            return 0;
        if (dp[idx].containsKey(diff))
            return dp[idx].get(diff);
        int ans = 0;
        for (int j = idx + 1; j < nums.length; j++) {
            if (nums[j] - nums[idx] == diff)
                ans = Math.max(ans, 1 + solve(j, diff, nums , dp));
        }
        dp[idx].put(diff, ans); 
        return ans;
    }

    public int longestArithSeqLength(int[] nums) {
        int ans = 2;
        Map<Integer, Integer> dp[] = new HashMap[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, 2 + solve(j, nums[j] - nums[i], nums, dp));
            }

        }
        return ans;
    }
}
