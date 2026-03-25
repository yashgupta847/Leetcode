class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        long sum1 = 0;
        int i = 0;
        while (i < grid.length - 1) {
            for (int j = 0; j < grid[0].length; j++) {
                sum1 += grid[i][j];
            }
            i++;
            if (sum - sum1 == sum1)
                return true;
        }
        int j = 0;
        long sum2 = 0;
        while (j < grid[0].length - 1) {
            for (int p = 0; p < grid.length; p++) {
                sum2 += grid[p][j];
            }
            j++;
            if (sum - sum2 == sum2)
                return true;
        }
        return false;
    }
}