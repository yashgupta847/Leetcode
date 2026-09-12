class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Stack<int[]> st = new Stack<>();
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1)
                st.add(new int[] { i, 0 });
            if (grid[i][m - 1] == 1)
                st.add(new int[] { i, m - 1 });
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1)
                st.add(new int[] { 0, j });
            if (grid[n - 1][j] == 1)
                st.add(new int[] { n - 1, j });
        }
        boolean visited[][] = new boolean[n][m];
        while (!st.isEmpty()) {
            int[] a = st.pop();
            int x = a[0];
            int y = a[1];
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
                    st.add(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;

    }
}