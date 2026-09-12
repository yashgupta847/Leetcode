class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    q.add(new int[] { i, j });
            }
        }
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] a = q.remove();
            int x = a[0];
            int y = a[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < n && nx >= 0 && ny >= 0 && ny < m && mat[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    mat[nx][ny] = 1 + mat[x][y];
                    q.add(new int[] { nx, ny });
                }
            }

        }
        return mat;
    }
}