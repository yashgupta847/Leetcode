class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        HashMap<String, Integer> map = new HashMap<>();
        int id = 0;

        for (List<String> eq : equations) {
            String u = eq.get(0);
            String v = eq.get(1);

            if (!map.containsKey(u))
                map.put(u, id++);

            if (!map.containsKey(v))
                map.put(v, id++);
        }

        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();

        for (int i = 0; i < id; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < equations.size(); i++) {

            int u = map.get(equations.get(i).get(0));
            int v = map.get(equations.get(i).get(1));

            adj.get(u).add(new double[]{v, values[i]});
            adj.get(v).add(new double[]{u, 1.0 / values[i]});
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String us = queries.get(i).get(0);
            String vs = queries.get(i).get(1);
            if (!map.containsKey(us) || !map.containsKey(vs)) {
                ans[i] = -1.0;
                continue;
            }

            int u = map.get(us);
            int v = map.get(vs);

            boolean[] visited = new boolean[id];
            Queue<double[]> q = new LinkedList<>();

            q.add(new double[]{u, 1.0});
            visited[u] = true;

            ans[i] = -1.0;

            while (!q.isEmpty()) {

                double[] curr = q.remove();

                int node = (int) curr[0];
                double product = curr[1];

                if (node == v) {
                    ans[i] = product;
                    break;
                }

                for (double[] edge : adj.get(node)) {

                    int neighbour = (int) edge[0];
                    double weight = edge[1];

                    if (!visited[neighbour]) {

                        visited[neighbour] = true;

                        q.add(new double[]{
                                neighbour,
                                product * weight
                        });
                    }
                }
            }
        }

        return ans;
    }
}