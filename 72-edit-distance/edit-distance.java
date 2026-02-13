class Solution {

    public int f(String word1, String word2, int i, int j, int[][] dp) {
        if (j < 0)
            return i + 1;
        if (i < 0)
            return j + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = f(word1, word2, i - 1, j - 1, dp);
        } else {
            int delete = 1 + f(word1, word2, i - 1, j, dp);
            int replace = 1 + f(word1, word2, i - 1, j - 1, dp);
            int insert = 1 + f(word1, word2, i, j - 1, dp);
            return dp[i][j] = Math.min(delete, Math.min(replace, insert));
        }
    }

    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        if (i == 0 && j == 0)
            return 0;
        int[][] dp = new int[i][j];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(word1, word2, i - 1, j - 1, dp);
    }
}