class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[heights.length][heights[0].length];
        for (int[] dist1 : dist)
            Arrays.fill(dist1, Integer.MAX_VALUE);
        dist[0][0] = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] dim = pq.remove();
            int x = dim[0];
            int y = dim[1];

            int distance = dim[2];
            if (x == n - 1 && y == m - 1)
                return distance;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && dist[nx][ny] > Math.max(distance, Math.abs(heights[nx][ny] - heights[x][y]))) {
                    pq.add(new int[] { nx, ny, Math.max(distance, Math.abs(heights[nx][ny] - heights[x][y])) });
                    dist[nx][ny] = Math.max(distance, Math.abs(heights[nx][ny] - heights[x][y]));
                }
            }
        }
        return -1;
    }
}