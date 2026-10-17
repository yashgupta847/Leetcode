class Solution {
    public int findSum(int i) {
        int ans = 0;
        while (i != 0) {
            int rem = i % 10;
            ans += rem;
            i /= 10;
        }
        return ans;
    }

    public int minSwaps(int[] nums) {
        ArrayList<int[]> adj = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = findSum(nums[i]);
            adj.add(new int[] { sum, i });
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            graph.add(new ArrayList<>());
        }

        Collections.sort(adj, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return nums[a[1]] - nums[b[1]];
        });
        for (int i = 0; i < nums.length; i++) {
            graph.get(i).add(adj.get(i)[1]);
        }
        ;
        int cycle = 0;
        boolean visited[] = new boolean[nums.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cycle++;
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int a = q.remove();
                    for (int neighb : graph.get(a)) {
                        if (!visited[neighb]) {
                            q.add(neighb);
                            visited[neighb] = true;
                        }
                    }
                }
            }
        }
       return nums.length - cycle; 
    }
}