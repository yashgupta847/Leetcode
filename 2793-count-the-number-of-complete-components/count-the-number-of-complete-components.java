class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                st.push(i);
                visited[i] = true;

                int vertices = 0;
                int edgesCount = 0;

                while (!st.isEmpty()) {

                    int now = st.pop();

                    vertices++;
                    edgesCount += adj.get(now).size();

                    for (int neigh : adj.get(now)) {

                        if (!visited[neigh]) {
                            visited[neigh] = true;
                            st.push(neigh);
                        }
                    }
                }
                edgesCount /= 2;
                if (edgesCount == vertices * (vertices - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }
}