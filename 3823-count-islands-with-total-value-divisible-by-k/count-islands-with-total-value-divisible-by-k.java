class Solution {
    public int countIslands(int[][] grid, int k) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int cnt = 0;
        int m = grid[0].length;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long ans = 0;
                if (grid[i][j] != 0 && !visited[i][j]) {
                    q.add(new int[] { i, j });
                  
                    while (!q.isEmpty()) {
                        int[] dim = q.remove();
                        int x = dim[0];
                        int y = dim[1];
                        ans += grid[x][y];
                        visited[x][y] = true;
                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && grid[nx][ny] != 0) {
                                q.add(new int[] { nx, ny });
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    if (ans % k == 0)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}