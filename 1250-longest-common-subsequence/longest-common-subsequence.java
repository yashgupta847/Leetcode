class Solution {
    public int f(String a, String b, int x, int y, int[][] dp) {
        if (x < 0 || y < 0)
            return 0;
        if (dp[x][y] != -1)
            return dp[x][y];
        if (a.charAt(x) == b.charAt(y))
            return 1 + f(a, b, x - 1, y - 1, dp);
        return dp[x][y] = Math.max(f(a, b, x - 1, y, dp), f(a, b, x, y - 1, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }
}