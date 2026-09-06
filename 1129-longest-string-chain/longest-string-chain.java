class Solution {
    public boolean compare(int i, int j, String[] words) {
        String a = words[i];
        String b = words[j];
        if (1 + a.length() != b.length())
            return false;
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

                r++;
            }
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (compare(i, j, words) && 1 + dp[i] > dp[j]) {
                    dp[j] = 1 + dp[i];
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            maxi = Math.max(dp[i], maxi);
        }
        return maxi;
    }
}