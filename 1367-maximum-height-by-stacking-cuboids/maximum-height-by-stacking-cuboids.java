class Solution {
    public int solve(int[][] c, int idx, int prev) {
        if (idx == c.length)
            return 0;
        int take = 0;
        if (prev == -1 || (c[prev][0] <= c[idx][0] && c[prev][1] <= c[idx][1] && c[prev][2] <= c[idx][2])) {
            take = c[idx][2] + solve(c, idx + 1, idx);
        }
        int nottake = solve(c, idx + 1, prev);
        return Math.max(take, nottake);

    }

    public int maxHeight(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            Arrays.sort(c[i]);
        }
        Arrays.sort(c, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];
        });
        return solve(c, 0, -1);
    }
}