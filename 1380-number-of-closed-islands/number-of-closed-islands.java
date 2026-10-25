class Solution {
    public void f(boolean[][] visited, int[][] grid, int i, int j, int[][] dir) {
        Stack<int[]> st = new Stack<>();
        st.add(new int[] { i, j });
        while (!st.isEmpty()) {
            int[] dim = st.pop();
            int x = dim[0];
            int y = dim[1];
            visited[x][y] = true;
            for (int[] dirs : dir) {
                int nx = x + dirs[0];
                int ny = y + dirs[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]
                        && grid[nx][ny] == 0) {
                    st.add(new int[] { nx, ny });
                }
            }
        }
    }

    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0 && !visited[0][i]) {
                q.add(new int[] { 0, i });
                while (!q.isEmpty()) {
                    int[] dim = q.remove();
                    int x = dim[0];
                    int y = dim[1];
                    visited[x][y] = true;
                    for (int[] dirs : dir) {
                        int nx = dirs[0] + x;
                        int ny = dirs[1] + y;
                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]
                                && grid[nx][ny] == 0) {
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
            if (grid[grid.length - 1][i] == 0 && !visited[grid.length - 1][i]) {
                q.add(new int[] { grid.length - 1, i });
                while (!q.isEmpty()) {
                    int[] dim = q.remove();
                    int x = dim[0];
                    int y = dim[1];
                    visited[x][y] = true;

                    for (int[] dirs : dir) {
                        int nx = dirs[0] + x;
                        int ny = dirs[1] + y;
                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]
                                && grid[nx][ny] == 0) {
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0 && !visited[i][0]) {
                q.add(new int[] { i, 0 });
                while (!q.isEmpty()) {
                    int[] dim = q.remove();
                    int x = dim[0];
                    int y = dim[1];
                    visited[x][y] = true;

                    for (int[] dirs : dir) {
                        int nx = dirs[0] + x;
                        int ny = dirs[1] + y;
                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]
                                && grid[nx][ny] == 0) {
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
            if (grid[i][grid[0].length - 1] == 0 && !visited[i][grid[0].length - 1]) {
                q.add(new int[] { i, grid[0].length - 1 });
                while (!q.isEmpty()) {
                    int[] dim = q.remove();
                    int x = dim[0];
                    int y = dim[1];
                    visited[x][y] = true;

                    for (int[] dirs : dir) {
                        int nx = dirs[0] + x;
                        int ny = dirs[1] + y;
                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]
                                && grid[nx][ny] == 0) {
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    ans++;
                    f(visited, grid, i, j, dir);
                }
            }
        }
        return ans;
    }
}