class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        long l = 1;
        long r = x;
        long ans = -1;
        while(l <= r){
            long mid = (l+r)/2;
            if(mid * mid <= x) {
                ans = mid;
                l = mid+1;
            }
            else if(mid*mid > x) r = mid-1;
        }
        return (int)ans;
    }
}