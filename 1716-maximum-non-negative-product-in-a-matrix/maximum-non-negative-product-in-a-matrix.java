class Solution {

    Long[][][] dp; 
    public long[] f(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length)
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return new long[]{grid[i][j], grid[i][j]};
        }

        if (dp[i][j][0] != null) {
            return new long[]{dp[i][j][0], dp[i][j][1]};
        }

        long[] right = f(grid, i, j + 1);
        long[] down = f(grid, i + 1, j);

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (long val : new long[]{right[0], right[1], down[0], down[1]}) {
            if (val == Long.MIN_VALUE || val == Long.MAX_VALUE) continue;

            long prod = grid[i][j] * val;
            max = Math.max(max, prod);
            min = Math.min(min, prod);
        }

        dp[i][j][0] = max;
        dp[i][j][1] = min;

        return new long[]{max, min};
    }

    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new Long[n][m][2];

        long[] res = f(grid, 0, 0);

        if (res[0] < 0) return -1;
        return (int)(res[0] % 1000000007);
    }
}