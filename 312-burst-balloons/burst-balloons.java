class Solution {

    int[][] dp;
    int[] arr;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);

        return solve(1, n);
    }

    public int solve(int i, int j) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int max = 0;

        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1]
                    + solve(i, k - 1)
                    + solve(k + 1, j);
            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }
}