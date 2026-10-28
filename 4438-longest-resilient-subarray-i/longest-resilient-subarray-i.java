class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int ans = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int r = nums[i] % k;
            if (r == nums[i - 1] % k) {
                len++;
            } else
                len = 1;
            if ((len - 1) * r % k == 0)
                ans = Math.max(ans, len);
        }
        return ans;
    }
}