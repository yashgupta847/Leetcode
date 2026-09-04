class Solution {
    public int f(String s, String t, int i, int j, int[][] dp) {

        if (j == t.length())
            return 1;
        else if (i == s.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = f(s, t, i + 1, j + 1 , dp);
        }
        int nottake = f(s, t, i + 1, j , dp);
        return dp[i][j] = take + nottake;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(s, t, 0, 0, dp);
    }
}