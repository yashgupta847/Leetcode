class Solution {
    public boolean containsCycle(char[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    q.add(new int[] { i, j, -1, -1 });
                    // int cnt = 1;
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] a = q.poll();
                        int x = a[0];
                        int y = a[1];
                        int px = a[2];
                        int py = a[3];
                        // int cnt = 0;
                        // cnt++;
                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx < grid.length && nx >= 0 && ny < grid[0].length && ny >= 0
                                    && grid[nx][ny] == grid[x][y]) {
                                // cnt++;
                                if (!visited[nx][ny]) {
                                    // return true;
                                    visited[nx][ny] = true;
                                    q.add(new int[] { nx, ny, x, y });
                                } else if (nx != px || ny != py) {
                                    // q.add(new int[] { grid[nx][ny] - 'a', nx, ny });
                                    // visited[nx][ny] = true;
                                    return true;
                                }
                            }
                        }
                    }
                }

            }
        }
        return false;
    }
}