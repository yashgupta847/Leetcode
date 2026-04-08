class Solution {
    public int MOD = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            while (idx <= queries[i][1]) {
                nums[idx] = (int)((1L*nums[idx] * queries[i][3]) % MOD);
                idx += queries[i][2];
            }
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}