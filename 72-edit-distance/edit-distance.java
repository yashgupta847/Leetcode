class Solution {
    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = f(s1, s2, i + 1, j + 1, dp);
        else {
            int delete = 1 + f(s1, s2, i + 1, j, dp);
            int insert = 1 + f(s1, s2, i, j + 1, dp);
            int replace = 1 + f(s1, s2, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(delete, Math.min(insert, replace));
        }
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(word1, word2, 0, 0, dp);
    }
}