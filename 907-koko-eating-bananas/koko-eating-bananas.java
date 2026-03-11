class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int total = 0;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            total += piles[i];
            r = Math.max(r, piles[i]);
        }
        int ans = Integer.MAX_VALUE; 
        int l = 1;
        while(l<=r){
            int mid = (l+r)/2;
            int totalHours = 0;
            for(int i = 0 ; i < piles.length ;i++){
                totalHours += Math.ceil((double)piles[i]/mid);
            }
            if(totalHours > h){
                l = mid+1;
            } else {
                ans = Math.min(ans , mid);
                r = mid-1;
            }
        }
        return ans;
    }
}