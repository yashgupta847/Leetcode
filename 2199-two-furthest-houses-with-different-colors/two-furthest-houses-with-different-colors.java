class Solution {
    // public int f(int[] colors, int i, int j, int[][] dp) {

    //     if (i > j || i > colors.length - 1 || j < 0)
    //         return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if (colors[i] == colors[j]) {
    //         return dp[i][j] = Math.max(f(colors, i + 1, j, dp), f(colors, i, j - 1, dp));
    //     }
    //     return dp[i][j] = Math.abs(j - i);
    // }

    public int maxDistance(int[] colors) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[0])
                ans = Math.max(ans, i - 0);
            if (colors[i] != colors[colors.length - 1])
                ans = Math.max(ans, colors.length - 1 - i);
        }
        return ans;
    }
}