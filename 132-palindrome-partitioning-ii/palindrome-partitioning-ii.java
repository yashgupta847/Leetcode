class Solution {
    public boolean isPalindrome(String s , int i , int j) {
        int l = i;
        int r = j;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            r--;
            l++;
        }

        return true;
    }

    public int f(String s, int i, int[] dp) {
        if (i == s.length())
            return 0;
        if (dp[i] != -1)
            return dp[i];
        // String temp = "";
        int min_cost = Integer.MAX_VALUE;
        for (int k = i; k < s.length(); k++) {
            // temp += s.charAt(k);
            if (isPalindrome(s , i , k)) {
                int cost = 1 + f(s, k + 1 , dp);
                min_cost = Math.min(min_cost, cost);
            }
        }
        return dp[i] = min_cost;

    }

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(s, 0, dp) - 1;
    }
}