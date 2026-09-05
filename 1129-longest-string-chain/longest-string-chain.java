class Solution {
    public boolean compare(String[] words, int i, int j) {
        if (words[i].length() != 1 + words[j].length()) {
            return false;
        }
        String a = words[i];
        String b = words[j];
        int l = 0;
        int r = 0;
        int diff = 0;
        while (l < a.length() && r < b.length()) {
            if (a.charAt(l) == b.charAt(r)) {
                l++;
                r++;
            } else {
                diff++;

                if (diff > 1)
                    return false;

                l++;
            }
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int[] dp = new int[words.length];
        // for (int[] dp1 : dp)
        Arrays.fill(dp, -1);
        int maxi = 1;
        for (int i = 0; i < words.length; i++) {
            maxi = Math.max(maxi, f(i, words, dp));
        }
        return maxi;
    }

    public int f(int idx, String[] words, int[] dp) {
        if (dp[idx] != -1)
            return dp[idx];

        int ans = 1;
        for (int j = idx + 1; j < words.length; j++) {
            if (compare(words, idx, j)) {
                ans = Math.max(ans, 1 + f(j, words, dp));
            }
        }
        return dp[idx] = ans;
    }
}