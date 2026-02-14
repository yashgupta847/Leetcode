class Solution {
    public int f(String s, int i , int[] dp) {

        if (i == s.length())
            return 1;
        if ((s.charAt(i) - '0') == 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int ways = 0;
        ways += f(s, i + 1 , dp);
        if (i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            if (num >= 10 && num < 27) {
                ways += f(s, i + 2 , dp);
            }
        }
        return dp[i] = ways;
    }

    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(s, 0, dp);
    }
}