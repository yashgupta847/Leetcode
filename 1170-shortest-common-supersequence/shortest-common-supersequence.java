class Solution {
    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + f(s1, s2, i + 1, j + 1, dp);

        return dp[i][j] = Math.max(
                f(s1, s2, i + 1, j, dp),
                f(s1, s2, i, j + 1, dp));
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        f(str1, str2, 0, 0, dp);
        int l = 0;
        int r = 0;
        StringBuilder s = new StringBuilder();
        while (l < str1.length() && r < str2.length()) {

            if (str1.charAt(l) == str2.charAt(r)) {
                s.append(str1.charAt(l));
                l++;
                r++;
            } else if (dp[l + 1][r] >= dp[l][r + 1]) {
                s.append(str1.charAt(l));
                l++;
            } else {
                s.append(str2.charAt(r));
                r++;
            }
        }
        while (l < str1.length()) {
            s.append(str1.charAt(l));
            l++;
        }

        while (r < str2.length()) {
            s.append(str2.charAt(r));
            r++;
        }

        return s.toString();
    }
}