class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        if(n== 3) return 5;
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            int left = i - 1;
            int right = n - i;
            ans += numTrees(left)*numTrees(right);
        }
        return ans;
    }
}