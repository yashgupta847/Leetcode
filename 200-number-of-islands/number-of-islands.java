class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        // for (int i = 0; i < grid.length; i++) {
        //     for(int j =0 ; j < grid[0].length ; j++){
        //         if(grid[i][j] == '1'){
        //            q.add(new int[]{i,j})
        //         }
        //     }
        // }
        int count = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    visit[i][j] = true;
                    q.add(new int[] { i, j });
                    count++;
                    while (!q.isEmpty()) {
                        int[] a = q.poll();
                        int x = a[0];
                        int y = a[1];
                        visit[x][y] = true;
                        for (int[] dir : dirs) {
                            int p = dir[0];
                            int r = dir[1];
                            if (p + x < grid.length && r + y < grid[0].length && p + x >= 0 && r + y >= 0
                                    && !visit[p + x][r + y] && grid[p + x][r + y] == '1') {
                                q.add(new int[] { p + x, r + y });
                                visit[p + x][r + y] = true;

                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}