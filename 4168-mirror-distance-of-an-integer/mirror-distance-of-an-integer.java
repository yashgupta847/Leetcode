class Solution {
    public int mirrorDistance(int n) {
        int ans = 0;
        int actual =  n;
        while (n != 0) {
            int a = n % 10;
            ans = ans * 10 + a;
            n /= 10;
        }
        int a = ans - actual;
        return Math.abs(a);
    }
}