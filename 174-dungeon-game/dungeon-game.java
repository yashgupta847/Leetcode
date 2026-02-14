class Solution {
    int n, m;

    public int f(int[][] dungeon, int i, int j, int[][] dp) {
        if (i >= n || j >= m)
            return Integer.MAX_VALUE;
        if (i == n - 1 && j == m - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = f(dungeon, i + 1, j, dp);
        int right = f(dungeon, i, j + 1, dp);

        int need = Math.min(down, right) - dungeon[i][j];

        return dp[i][j] = Math.max(1, need);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        return f(dungeon, 0, 0, dp);
    }
}