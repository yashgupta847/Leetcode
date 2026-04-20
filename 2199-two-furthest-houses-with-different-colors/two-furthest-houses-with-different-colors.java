class Solution {
    public int f(int[] colors, int i, int j, int[][] dp) {

        if (i > j || i > colors.length - 1 || j < 0)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if (colors[i] == colors[j]) {
            return dp[i][j] = Math.max(f(colors, i + 1, j, dp), f(colors, i, j - 1, dp));
        }
        return dp[i][j] = Math.abs(j - i);
    }

    public int maxDistance(int[] colors) {
        int[][] dp = new int[colors.length][colors.length];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(colors, 0, colors.length - 1, dp);
    }
}