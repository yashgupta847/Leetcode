class Solution {
    public boolean f(String s, String p, int i, int j, Boolean[][] dp) {
        if (i < 0 && j < 0)
            return true;
        if (j < 0)
            return false;

        if (i < 0) {
            //for (int l = 0; l <= j; l++) {
            if (p.charAt(j) == '*')
                return f(s, p, i, j - 2, dp);
            //}
            return false;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
            return dp[i][j] = f(s, p, i - 1, j - 1, dp);
        if (p.charAt(j) == '*') {
            boolean skip = f(s, p, i, j - 2, dp);
            boolean take = false;

            if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i))
                take = f(s, p, i - 1, j, dp);

            return dp[i][j] = skip || take;
        }

        return false;

    }

    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()][p.length()];
        return f(s, p, s.length() - 1, p.length() - 1, dp);
    }
}