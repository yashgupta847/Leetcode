class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //Using BFS
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        int k = 0;
        for (int edge[] : graph) {
            for (int i = 0; i < edge.length; i++) {
                adj.get(graph[k][i]).add(k);
            }
            k++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inD = new int[graph.length];
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> a = adj.get(i);
            for (int e : a) {
                inD[e]++;
            }
        }
        for (int i = 0; i < inD.length; i++) {
            if (inD[i] == 0) {
                ans.add(i);
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int neigh : adj.get(a)) {
                inD[neigh]--;
                if (inD[neigh] == 0) {
                    ans.add(neigh);
                    q.add(neigh);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}