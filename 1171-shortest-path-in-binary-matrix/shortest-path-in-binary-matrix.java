class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int[] dist1 : dist)
            Arrays.fill(dist1, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        if (grid[0][0] == 0) {
            q.add(new int[] { 0, 0 });
            dist[0][0] = 1;
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 1 } };
        while (!q.isEmpty()) {
            int[] dim = q.remove();
            int x = dim[0];
            int y = dim[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0) {
                    if (1 + dist[x][y] < dist[nx][ny]) {
                        dist[nx][ny] = 1 + dist[x][y];
                        q.add(new int[] { nx, ny });
                    }
                }

            }

        }

        return dist[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1][m - 1];
    }
}