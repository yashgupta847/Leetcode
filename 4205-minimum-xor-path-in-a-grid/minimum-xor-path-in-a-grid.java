class Solution {
    public int f(int[][] grid, int i, int j , int xor , Integer[][][] dp) {       
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        xor ^= grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return xor;
        }

        if(dp[i][j][xor] != null) return dp[i][j][xor];

        int down = f(grid, i + 1, j , xor , dp);
        int right = f(grid, i, j + 1 , xor , dp);
        int ans = Math.min(down, right);
        return dp[i][j][xor] = ans;
    }
    public int minCost(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][1024];
        return f(grid, 0, 0 , 0 ,dp);
    }
}