class Solution {
    public int f(int[] arr, int[][] max, int i, int j , int[][] dp) {
        if (i == j)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            ans = Math.min(ans, max[i][k] * max[k + 1][j] + f(arr, max, i, k , dp) + f(arr, max, k + 1, j , dp));
        }
        return dp[i][j] = ans;
    }

    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        int[][] max = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            max[i][i] = arr[i];
            int nowMax = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                nowMax = Math.max(nowMax, arr[j]);
                max[i][j] = nowMax;
            }
        }
        return f(arr, max, 0, arr.length - 1 , dp);
    }
}