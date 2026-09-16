class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new int[] { v, w });
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while (!q.isEmpty()) {
            int a = q.remove();
            for (int[] neighb : adj.get(a)) {
                if (dist[neighb[0]] > dist[a] + neighb[1]) {
                    dist[neighb[0]] = dist[a] + neighb[1];
                    q.add(neighb[0]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n; i++){
            ans = Math.max(ans , dist[i]);
        }


        if(ans == Integer.MAX_VALUE) return -1;
        return ans;

    }
}