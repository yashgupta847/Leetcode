class Solution {
    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || s2.length() == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + f(s1, s2, i + 1, j + 1, dp);
        return dp[i][j] = Math.max(f(s1, s2, i + 1, j, dp), f(s1, s2, i, j + 1, dp));
    }

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        int ans = f(word1, word2, 0, 0, dp);
        return word1.length() + word2.length() - 2 * ans;
    }
}