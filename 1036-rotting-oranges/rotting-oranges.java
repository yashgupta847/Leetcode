class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> st = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    st.add(new int[] { i, j });
                } else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        int time = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!st.isEmpty() && fresh > 0) {
            int size = st.size();
            for(int i = 0 ; i < size ; i++){
                int[] dim = st.remove();
                int x = dim[0];
                int y = dim[1];
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                        st.add(new int[]{nx , ny});
                        grid[nx][ny] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}