class Solution {
    public int f(int[][] matrix, int i, int j, int[][] dirs, int[][] dp) {

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 1;

        for (int[] dir : dirs) {

            int nx = i + dir[0];
            int ny = j + dir[1];

            if (nx >= 0 && ny >= 0 &&
                    nx < matrix.length && ny < matrix[0].length &&
                    matrix[nx][ny] > matrix[i][j]) {

                ans = Math.max(ans,
                        1 + f(matrix, nx, ny, dirs, dp));
            }
        }

        return dp[i][j] = ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        for (int[] dp1 : dp)
            Arrays.fill(dp1, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, f(matrix, i, j, dirs, dp));
            }
        }
        return ans;
    }
}