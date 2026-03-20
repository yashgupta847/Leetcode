class Solution {
    public int mod = 1000000007;
    public int power(int base, int exp) {
        long res = 1;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) res;
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] <= target) {
                ans =(ans+ power(2, (r - l)))%mod;
                l++;

            }
        }
        return ans;
    }
}