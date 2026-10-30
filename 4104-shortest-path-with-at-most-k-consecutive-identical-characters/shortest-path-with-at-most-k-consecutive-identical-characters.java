class Solution {
    class Pair {
        int node;
        int cost;
        int count;
        Pair(int node, int cost, int count) {
            this.node = node;
            this.cost = cost;
            this.count = count;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );

        dist[0][1] = 0;
        pq.add(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;
            int count = curr.count;

            if (cost > dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return cost;
            }

            for (int[] neigh : adj.get(node)) {

                int next = neigh[0];
                int newCost = cost + neigh[1];

                int newCount;
                if (labels.charAt(node) == labels.charAt(next)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }
                if (newCount > k) {
                    continue;
                }
                if (newCost < dist[next][newCount]) {
                    dist[next][newCount] = newCost;
                    pq.add(new Pair(next, newCost, newCount));
                }
            }
        }
        return -1;
    }
}