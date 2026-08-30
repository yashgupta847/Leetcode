class Solution {
    public int solve(int[][] e) {
        ArrayList<Integer> adj = new ArrayList<>();
        adj.add(e[0][1]);

        for (int i = 1; i < e.length; i++) {
            if (adj.get(adj.size() - 1) < e[i][1]) {
                adj.add(e[i][1]);
            } else {
                int l = 0;
                int r = adj.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (adj.get(mid) < e[i][1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                adj.set(l, e[i][1]);
            }
        }
        return adj.size();
    }

    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        return solve(e);
    }
}