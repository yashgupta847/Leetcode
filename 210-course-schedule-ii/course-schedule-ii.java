class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] inD = new int[numCourses];
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> a = adj.get(i);
            for (int e : a) {
                inD[e]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < inD.length; i++) {
            if (inD[i] == 0) {
                q.add(i);
                ans.add(i);
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int neighb : adj.get(a)) {
                inD[neighb]--;
                if (inD[neighb] == 0) {
                    q.add(neighb);
                    ans.add(neighb);
                }
            }
        }
        if (ans.size() != numCourses) {
            return new int[] {};
        }
        int[] a = new int[numCourses];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.remove(ans.size() - 1);
        }
        return a;

    }
}
