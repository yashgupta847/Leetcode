class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[numCourses];
            q.add(u);
            boolean found = false;
            while (!q.isEmpty()) {
                int a = q.remove();
                for (int neighb : adj.get(a)) {
                    if (neighb == v) {
                        ans.add(true);
                        found = true;
                        break;
                    }
                    if (!visited[neighb])
                        q.add(neighb);
                }
                if(found) break;
            }
            if(!found){
                ans.add(false); 
            }
        }
        return ans;
    }
}