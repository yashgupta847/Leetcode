class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int maxIdx = 0;
        int dp[] = new int[nums.length];
        int hash[] = new int[nums.length];
        Arrays.fill(dp, 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }
        while (hash[maxIdx] != maxIdx) {
            ans.add(nums[maxIdx]);
            maxIdx = hash[maxIdx];
        }
        ans.add(nums[maxIdx]);
        return ans;
    }
}