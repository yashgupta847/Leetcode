class Solution {

    public int max(int[] arr, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            max = Math.max(arr[k], max);
        }
        return max;
    }

    public int f(int[] ans, int k, int idx, int[] dp) {
        if (idx == ans.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int cost = Integer.MIN_VALUE;
        for (int p = idx; p < Math.min(ans.length, idx + k); p++) {
            int temp = max(ans, idx, p) * (p - idx + 1) + f(ans, k, p + 1, dp);
            cost = Math.max(temp, cost);
        }
        return dp[idx] = cost;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] ans = new int[arr.length];
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return f(arr, k, 0, dp);
    }
}