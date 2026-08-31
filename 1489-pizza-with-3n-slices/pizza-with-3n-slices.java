class Solution {
    public int f(int[] slices, int idx, int end, int eat, int[][] dp) {
        if (eat == slices.length / 3 || idx >= slices.length || idx == end + 1)
            return 0;

        if (dp[idx][eat] != -1)
            return dp[idx][eat];
        int take = f(slices, idx + 2, end, eat + 1, dp) + slices[idx];
        int nottake = f(slices, idx + 1, end, eat, dp);
        return dp[idx][eat] = Math.max(take, nottake);
    }

    public int maxSizeSlices(int[] slices) {
        int[][] dp = new int[slices.length][slices.length / 3];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        int one = f(slices, 0, slices.length - 2, 0, dp);
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        int two = f(slices, 1, slices.length - 1, 0, dp);
        return Math.max(one , two);
    }
}