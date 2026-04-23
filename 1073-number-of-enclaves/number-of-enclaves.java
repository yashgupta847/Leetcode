class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1)
                q.add(new int[] { i, 0 });
            if (grid[i][grid[0].length - 1] == 1)
                q.add(new int[] { i, grid[0].length - 1 });
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1) {
                q.add(new int[] { 0, j });
            }
            if (grid[grid.length - 1][j] == 1) {
                q.add(new int[] { grid.length - 1, j });
            }
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int a[] = q.poll();
            int x = a[0];
            int y = a[1];
            visit[x][y] = true;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny] && grid[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visit[i][j])
                    cnt++;
            }
        }
        return cnt;
    }
}