class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            ans = Math.min(ans, nums[mid]);
            if (nums[l] <= nums[mid]) {
                ans = Math.min(nums[l], ans);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}