class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        int n = grid.length;
        int m = grid[0].length;
        pq.add(new int[] { grid[0][0], 0, 0 });
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[n][m];
        while (!pq.isEmpty()) {
            int[] dims = pq.remove();
            int wt = dims[0];
            int x = dims[1];
            int y = dims[2];
            if (x == n - 1 && y == m - 1) {
                return wt;
            }
            if (visited[x][y])
                continue;
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    pq.add(new int[] { Math.max(grid[nx][ny], wt), nx, ny });
                }
            }
        }
        return -1;
    }
}