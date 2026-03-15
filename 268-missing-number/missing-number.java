class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length;
        for (int i = 0; i < nums.length; i++) {
            r = Math.max(r, nums[i]);
        }
        int ans = r * (r + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return ans - sum;
    }
}