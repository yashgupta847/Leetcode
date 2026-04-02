class Solution {
    public int f(int[][] coins, int i, int j, int dilute , Integer[][][] dp) {
        if(i >= coins.length || j >= coins[0].length) return Integer.MIN_VALUE;
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            if (coins[i][j] >= 0)
                return coins[i][j];
            else {
                if (dilute == 2)
                    return coins[i][j];
                return 0;
            }
        }
        if(dp[i][j][dilute] != null) return dp[i][j][dilute];
        int right = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && dilute < 2) {
            int skip = f(coins, i, j + 1, dilute + 1 , dp);
            int next = f(coins, i, j + 1, dilute , dp);
            int take = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + next;
            right = Math.max(skip, take);
        } else {
            int next = f(coins, i, j + 1, dilute , dp);
            if(next != Integer.MIN_VALUE)
                right = coins[i][j] + next;
        }
        int down = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && dilute < 2) {
            int skip = f(coins, i + 1, j, dilute + 1 , dp);
            int next = f(coins, i + 1, j, dilute , dp);
            int take = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + next;
            down = Math.max(skip, take);
        } else {
            int next = f(coins, i + 1, j, dilute , dp);
            if(next != Integer.MIN_VALUE)
                down = coins[i][j] + next;
        }
        return dp[i][j][dilute] =  Math.max(down, right);
    }
    public int maximumAmount(int[][] coins) {
        Integer[][][] dp = new Integer[coins.length][coins[0].length][3];
        return f(coins, 0, 0, 0 , dp);
    }
}