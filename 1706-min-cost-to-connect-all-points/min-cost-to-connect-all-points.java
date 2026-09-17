class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[] { j, cost });
                adj.get(j).add(new int[] { i, cost });
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[] { 0, -1 });
        int sum = 0;
        boolean[] visited = new boolean[points.length];
        while (!pq.isEmpty()) {
            int[] content = pq.remove();
            int i = content[0];
            int cost = content[1];
            if (visited[i])
                continue;
            visited[i] = true;
            if (cost != -1) {
                sum += cost;
            }
            for (int[] neighb : adj.get(i)) {
                int neighbor = neighb[0];
                int dist = neighb[1];
                if (!visited[neighbor]) {
                    pq.add(new int[] { neighbor, dist });
                }
            }
        }
        return sum;
    }
}