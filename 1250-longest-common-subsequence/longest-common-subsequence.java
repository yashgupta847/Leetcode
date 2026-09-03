class Solution {
    public int f(String s1, String s2, int idx1, int idx2, int[][] dp) {
        if (idx1 == s1.length() || idx2 == s2.length()) {
            return 0;
        }
        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        if (s1.charAt(idx1) == s2.charAt(idx2))
            return 1 + f(s1, s2, idx1 + 1, idx2 + 1, dp);
        return dp[idx1][idx2] = Math.max(f(s1, s2, idx1, idx2 + 1, dp), f(s1, s2, idx1 + 1, idx2, dp));

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(text1, text2, 0, 0, dp);
    }
}