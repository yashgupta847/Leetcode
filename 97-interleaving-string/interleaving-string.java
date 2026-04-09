class Solution {
    Boolean dp[][];

    public boolean f(String s1, String s2, String s3, int i1, int i2, int i3) {
        if (i1 == s1.length()) {
            return s2.substring(i2).equals(s3.substring(i3));
        }

        if (i2 == s2.length()) {
            return s1.substring(i1).equals(s3.substring(i3));
        }
        if (i3 == s3.length()) {
            if (i1 == s1.length() && i2 == s2.length())
                return true;
            return false;
        }
        if (dp[i1][i2] != null)
            return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2) && s2.charAt(i2) == s3.charAt(i3)) {
            return dp[i1][i2] = f(s1, s2, s3, i1 + 1, i2, i3 + 1) || f(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }
        if (s1.charAt(i1) == s3.charAt(i3)) {
            return dp[i1][i2] = f(s1, s2, s3, i1 + 1, i2, i3 + 1);
        }
        if (s2.charAt(i2) == s3.charAt(i3)) {
            return dp[i1][i2] = f(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }
        return dp[i1][i2] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()][s2.length()];
        return f(s1, s2, s3, 0, 0, 0);
    }
}