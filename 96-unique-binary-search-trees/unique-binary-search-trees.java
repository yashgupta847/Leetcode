class Solution {
    // public int solve(int idx, int n) {
    //     if(idx == 0 || idx == 1) return 1;
    //     return solve(idx - 1, n) * solve(n - idx, n);
    // }

    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            ans += numTrees(left) * numTrees(right);
        }
        return ans;
    }
}