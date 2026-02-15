class Solution {
    public int almostPalindromic(String s) {
        if (ispal(s)) return s.length();

        int n = s.length();
        int ans = 1;

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

                int len = j - i + 1;

                // almost palindrome condition
                if (dp[i][j] >= len - 1) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }

    public boolean ispal(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}