class Solution {

    public int f(int[] cuts, int i, int j, int[][] dp) {
        if (i >= j - 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = cuts[j] - cuts[i] + f(cuts, i, k, dp) + f(cuts, k, j, dp);
            min = Math.min(cost, min);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = cuts[i - 1];
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        // for(int i = 0 ; i < n ; i++){
        //     arr[i] = i+1;
        // }
        return f(arr, 0, arr.length - 1, dp);
    }
}