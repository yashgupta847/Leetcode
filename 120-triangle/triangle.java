class Solution {
    public int f(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);
        // if (i >= triangle.size())
        //     return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int down = Integer.MAX_VALUE;
        int diagDown = Integer.MAX_VALUE;
        down = triangle.get(i).get(j) + f(triangle, i + 1, j, dp);
        diagDown = triangle.get(i).get(j) + f(triangle, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(down, diagDown);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        // for (int[] dp1 : dp) {
        //     Arrays.fill(dp1, -1);
        // }
        return f(triangle, 0, 0, dp);
    }
}