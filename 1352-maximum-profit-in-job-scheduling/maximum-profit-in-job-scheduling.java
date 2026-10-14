class Solution {
    int[] dp;
    public int f(int[][] jobs , int idx , int end){
        if(idx == jobs.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int nottaking = f(jobs , idx  +1  , end);
        int taking = 0;
        if(jobs[idx][0] >= end){
            int upperBound = uB(jobs , idx); 
            taking = jobs[idx][2] + f(jobs, upperBound , jobs[idx][1]);
        }
        return dp[idx] = Math.max(taking ,nottaking);
    }
    public int uB(int[][] jobs , int idx){
        int l = idx;
        int r = jobs.length-1;
        int ans = jobs.length;
        while(l <= r){
            int mid = (l + r)/2;
            if(jobs[mid][0] >= jobs[idx][1]){
                ans = mid;
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        return ans;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        dp = new int[startTime.length];
        Arrays.fill(dp , -1);
        int[][] jobs = new int[startTime.length][3];
        for(int i = 0 ; i < jobs.length ; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs , (a , b)->{
            return a[0] - b[0];
        });
        return f(jobs , 0  , -1);
    }
}
