class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            adj.get(u).add(new int[] { v, flights[i][2] });
        }
        Queue<int[]> pq = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[] { 0, src, 0 });
        while (!pq.isEmpty()) {
            int[] dim = pq.remove();
            int cost = dim[0];
            int who = dim[1];
            int noofstops = dim[2];
            if (noofstops > k)
                continue;

            for (int[] neighb : adj.get(who)) {
                int where = neighb[0];
                int howmuch = neighb[1];
                if (dist[where] > cost + howmuch && noofstops <= k) {
                    dist[where] = cost + howmuch;
                    pq.add(new int[]{dist[where] , where , noofstops + 1});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}