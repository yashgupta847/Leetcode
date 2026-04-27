class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] a = q.poll();
            int x = a[0], y = a[1];

            if (x == n - 1 && y == m - 1) return true;
            int dir = grid[x][y];
            if (dir == 1 || dir == 3 || dir == 5) {
                int ny = y - 1;
                if (ny >= 0 && !vis[x][ny]) {
                    int next = grid[x][ny];
                    if (next == 1 || next == 4 || next == 6) {
                        vis[x][ny] = true;
                        q.add(new int[]{x, ny});
                    }
                }
            }
            if (dir == 1 || dir == 4 || dir == 6) {
                int ny = y + 1;
                if (ny < m && !vis[x][ny]) {
                    int next = grid[x][ny];
                    if (next == 1 || next == 3 || next == 5) {
                        vis[x][ny] = true;
                        q.add(new int[]{x, ny});
                    }
                }
            }
            if (dir == 2 || dir == 5 || dir == 6) {
                int nx = x - 1;
                if (nx >= 0 && !vis[nx][y]) {
                    int next = grid[nx][y];
                    if (next == 2 || next == 3 || next == 4) {
                        vis[nx][y] = true;
                        q.add(new int[]{nx, y});
                    }
                }
            }
            if (dir == 2 || dir == 3 || dir == 4) {
                int nx = x + 1;
                if (nx < n && !vis[nx][y]) {
                    int next = grid[nx][y];
                    if (next == 2 || next == 5 || next == 6) {
                        vis[nx][y] = true;
                        q.add(new int[]{nx, y});
                    }
                }
            }
        }

        return false;
    }
}