class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        if (grid[0][0] <= k)
            ans++;
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
            if (grid[i][0] <= k)
                ans++;
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
            if (grid[0][j] <= k)
                ans++;
            else
                break;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
                if (grid[i][j] <= k)
                    ans++;
                else
                    break;
            }
        }
        return ans;
    }
}