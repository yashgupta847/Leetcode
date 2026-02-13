class Solution {
    public boolean f(String s, String p, int l, int r , Boolean[][] dp) {
        if (l < 0 && r < 0)
            return true;
        if (r < 0)
            return false;
        if (l < 0) {
            for (int i = 0; i <= r; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }
        if(dp[l][r] != null) return dp[l][r];

        if (s.charAt(l) == p.charAt(r) || p.charAt(r) == '?')
            return dp[l][r] = f(s, p, l - 1, r - 1 , dp);
        else if (p.charAt(r) == '*') {
            return dp[l][r] = f(s, p, l - 1, r , dp) || f(s, p, l, r - 1 , dp);
        } else {
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        int l = s.length();
        int r = p.length();
        Boolean[][] dp = new Boolean[l][r];
        return f(s, p, l - 1, r - 1 , dp);
    }
}