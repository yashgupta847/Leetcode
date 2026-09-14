class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }
        int[] inD = new int[numCourses];
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inD[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inD.length; i++) {
            if (inD[i] == 0)
                q.add(i);
        }
        ArrayList<Integer> ans1 = new ArrayList<>();
        while (!q.isEmpty()) {
            int a = q.remove();
            ans1.add(a);
            for (int n : adj.get(a)) {
                inD[n]--;
                if (inD[n] == 0)
                    q.add(n);
            }
        }
        if (ans1.size() != numCourses)
            return new int[] {};
        int[] ans = new int[numCourses];
        // int i = 0;
        for(int i = 0 ; i < ans1.size() ; i++){
            ans[i] = ans1.get(i);
        }
        return ans;
    }
}