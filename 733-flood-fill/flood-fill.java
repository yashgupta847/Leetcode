class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int[][] ans = new int[image.length][image[0].length];
        // for (int i = 0; i < image.length; i++) {
            // for (int j = 0; j < image[0].length; j++) {
                // ans[i][j] = image[i][j];
            // }
        // }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc, image[sr][sc] });
        image[sr][sc] = color;
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] a = q.remove();
            int x = a[0];
            int y = a[1];
            int nowColor = a[2];
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && !visited[nx][ny]
                        && image[nx][ny] == nowColor) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny, image[nx][ny] });
                    image[nx][ny] = color;
                }
            }
        }
        return image;
    }
}