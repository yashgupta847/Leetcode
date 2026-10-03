class Solution {
    public int numOfWays(int n) {

        int MOD = 1000000007;

        int[][] patterns = {
                { 0, 1, 2 }, { 0, 2, 1 },
                { 0, 1, 0 }, { 0, 2, 0 },
                { 1, 0, 2 }, { 1, 2, 0 },
                { 1, 0, 1 }, { 1, 2, 1 },
                { 2, 0, 1 }, { 2, 1, 0 },
                { 2, 1, 2 }, { 2, 0, 2 }
        };

        int[] dp = new int[12];
        Arrays.fill(dp, 1);
        for (int row = 1; row < n; row++) {
            int[] next = new int[12];
            for (int prev = 0; prev < 12; prev++) {

                for (int curr = 0; curr < 12; curr++) {

                    boolean valid = true;

                    for (int k = 0; k < 3; k++) {
                        if (patterns[prev][k] == patterns[curr][k]) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        next[curr] = (next[curr] + dp[prev]) % MOD;
                    }
                }
            }

            dp = next;
        }

        int ans = 0;

        for (int x : dp) {
            ans = (ans + x) % MOD;
        }

        return ans;
    }
}