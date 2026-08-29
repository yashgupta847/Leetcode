class Solution {
    public int f(int[] s , int idx , int currT , int[][] dp){

        if(idx == s.length){
            return 0;
        }
        if(dp[idx][currT] != -1) return dp[idx][currT];
        int take = f(s , idx+1 , currT+1 , dp) + currT*(s[idx]); 
        int notTake = f(s , idx+1 , currT , dp);
        return dp[idx][currT] = Math.max(take , notTake);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length + 1];
        for(int[] dp1 : dp){
            Arrays.fill(dp1 , -1);
        }
        return f(satisfaction, 0, 1, dp);
    }
}