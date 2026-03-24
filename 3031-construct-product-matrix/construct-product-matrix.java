class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;

        int[] flat = new int[n * m];
        int idx = 0;

        for (int[] row : grid) {
            for (int val : row) {
                flat[idx++] = val;
            }
        }

        int total = n * m;

        int[] prefix = new int[total];
        prefix[0] = 1;
        for (int i = 1; i < total; i++) {
            prefix[i] = (int)((1L * prefix[i - 1] * flat[i - 1]) % mod);
        }

        int[] suffix = new int[total];
        suffix[total - 1] = 1;
        for (int i = total - 2; i >= 0; i--) {
            suffix[i] = (int)((1L * suffix[i + 1] * flat[i + 1]) % mod);
        }

        int[][] ans = new int[n][m];
        idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int)((1L * prefix[idx] * suffix[idx]) % mod);
                idx++;
            }
        }

        return ans;
    }
}