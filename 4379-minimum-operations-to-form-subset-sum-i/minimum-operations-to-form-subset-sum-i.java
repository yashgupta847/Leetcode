class Solution {
    static final int INF = 1000000000;

    public int f(int[] nums, int sum, int idx, int[][] dp) {
        if (sum == 0)
            return 0;
        if (idx == nums.length)
            return INF;
        if (dp[idx][sum] != -1)
            return dp[idx][sum];
        int ans = f(nums, sum, idx + 1 , dp);
        int curr = nums[idx];
        int mulCost = 0;
        while (true) {
            int temp = curr;
            int cost = mulCost;
            while (temp > 0) {
                if (temp <= sum) {
                    int next = f(nums, sum - temp, idx + 1 , dp);
                    if (next != INF) {
                        ans = Math.min(ans, cost + next);
                    }
                }
                temp /= 2;
                cost++;
            }
            if (curr > sum)
                break;
            curr *= 2;
            mulCost++;
        }
        return dp[idx][sum] = ans;
    }

    public int minOperations(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        int ans = f(nums, sum, 0, dp);

        return ans == INF ? -1 : ans;
    }
}