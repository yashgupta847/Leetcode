class Solution {
    int[] dp;
    public int minCut(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, s) - 1;
    }
    int f(int i, String s) {
        int n = s.length();
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];  
        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                int cuts = 1 + f(j + 1, s);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return dp[i] = minCuts;
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}