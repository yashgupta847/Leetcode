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
                        if (x + 1 <= grid.length - 1 && grid[x + 1][y] == '1' && !visit[x + 1][y]) {
                            q.add(new int[] { x + 1, y });
                            visit[x + 1][y] = true;
                        }
                        if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == '1' && !visit[x][y + 1]) {
                            q.add(new int[] { x, y + 1 });
                            visit[x][1 + y] = true;
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1' && !visit[x][y - 1]) {
                            q.add(new int[] { x, y - 1 });
                            visit[x][y - 1] = true;
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1' && !visit[x - 1][y]) {
                            q.add(new int[] { x - 1, y });
                            visit[x - 1][y] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}