class Solution {
    public int numSubseq(int[] nums, int target) {
        final long MOD = 1_000_000_007L;
        Arrays.sort(nums);
        int n = nums.length;
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        int l = 0;
        int r = n - 1;
        long ans = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                ans = (ans + pow[r - l]) % MOD;
                l++;
            }
        }
        return (int) ans;
    }
}