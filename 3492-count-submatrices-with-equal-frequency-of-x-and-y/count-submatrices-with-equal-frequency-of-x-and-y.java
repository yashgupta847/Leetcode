class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] grid2 = new int[n][m];
        int[][] xCount = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    grid2[i][j] = 1;
                    xCount[i][j] = 1;
                } else if (grid[i][j] == 'Y') {
                    grid2[i][j] = -1;
                } else {
                    grid2[i][j] = 0;
                }
            }
        }

        int ans = 0;

        if (grid2[0][0] == 0 && xCount[0][0] >= 1)
            ans++;

        for (int j = 1; j < m; j++) {
            grid2[0][j] += grid2[0][j - 1];
            xCount[0][j] += xCount[0][j - 1];

            if (grid2[0][j] == 0 && xCount[0][j] >= 1)
                ans++;
        }

        for (int i = 1; i < n; i++) {
            grid2[i][0] += grid2[i - 1][0];
            xCount[i][0] += xCount[i - 1][0];

            if (grid2[i][0] == 0 && xCount[i][0] >= 1)
                ans++;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid2[i][j] = grid2[i][j]
                        + grid2[i - 1][j]
                        + grid2[i][j - 1]
                        - grid2[i - 1][j - 1];

                xCount[i][j] = xCount[i][j]
                        + xCount[i - 1][j]
                        + xCount[i][j - 1]
                        - xCount[i - 1][j - 1];

                if (grid2[i][j] == 0 && xCount[i][j] >= 1)
                    ans++;
            }
        }

        return ans;
    }
}