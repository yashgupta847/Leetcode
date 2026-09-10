class Solution {
    public int f(int i, int j, int[] arr, int[][] dp) {
        if (i >= j - 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = arr[i] * arr[j] * arr[k] + f(i, k, arr, dp) + f(k, j, arr, dp);
            ans = Math.max(cost, ans);
        }
        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }

        int maxi = Integer.MIN_VALUE;
        // for (int i = 1; i < arr.length-1; i++) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(0, arr.length - 1, arr, dp);
        // }
    }
}