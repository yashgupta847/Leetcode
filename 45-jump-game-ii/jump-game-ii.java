class Solution {
    int[] dp;
    public int f(int[] nums , int idx){
        if(idx == nums.length-1){
            return 0;
        } 
        if(idx >= nums.length){
            return Integer.MAX_VALUE;
        }
        if(dp[idx] != -1) return dp[idx];
        int actualAns = Integer.MAX_VALUE;
        for(int i = 1 ; i <= nums[idx] ; i++){
            int take  = f(nums , idx + i);
            if(take != Integer.MAX_VALUE){
                take += 1;
            }
            actualAns = Math.min(take , actualAns);
        }
        return dp[idx] = actualAns;
    }
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return f(nums , 0 );
    }
}