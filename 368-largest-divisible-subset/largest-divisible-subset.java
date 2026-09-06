class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.sort(nums);
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > dp[max]) {
                max = i;
            }
        }
        int idx = max;

        ans.add(nums[idx]);
        while (hash[idx] != idx) {
            ans.add(nums[hash[idx]]);
            idx = hash[idx];
        }
        return ans;
    }
}