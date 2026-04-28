class Solution {
    public int minOperations(int[][] grid, int x) {
        int remainder = grid[0][0] % x;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % x != remainder)
                    return -1;
            }
        }
        int n = grid.length;
        int m = grid[0].length;

        int[] arr = new int[n * m];
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[k] = grid[i][j];
                k++;
            }
        }
        Arrays.sort(arr);
        int ans = 0;
        int mid = arr[arr.length / 2];
        for (int i = 0; i < arr.length / 2; i++) {
            ans += (mid - arr[i]) / x;
        }
        for (int i = arr.length / 2 + 1; i < arr.length; i++) {
            ans += (arr[i] - mid) / x;
        }
        return ans;
    }
}