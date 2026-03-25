class Solution {
    public boolean f(String s, List<String> wordDict, HashSet<String> set, int idx, Boolean[] dp) {
        if (idx == s.length())
            return true;
        if (dp[idx] != null)
            return dp[idx];

        for (int i = idx; i < s.length(); i++) {
            if (set.contains(s.substring(idx, i + 1))) {
                if (f(s, wordDict, set, i + 1, dp))
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        return f(s, wordDict, set, 0, dp);
    }
}