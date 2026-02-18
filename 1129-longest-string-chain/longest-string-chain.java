class Solution {
    public boolean compare(String a, String b) {
        if (a.length() != b.length() + 1)
            return false;

        int i = 0, j = 0;
        while (i < a.length()) {
            if (j < b.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == b.length();
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int maxi = 1;
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < words.length; i++) {
            int curr = words[i].length();

            for (int j = 0; j < i; j++) {
                if (compare(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
                maxi = Math.max(maxi, dp[i]);
            }
        }
        return maxi;
    }
}