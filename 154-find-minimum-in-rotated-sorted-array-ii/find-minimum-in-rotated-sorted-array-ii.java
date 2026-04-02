class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        if (nums.length == 1)
            return nums[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] == nums[mid] && nums[mid] == nums[r] && l != mid) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                ans = Math.min(nums[l], ans);
                l = mid + 1;
            } else if (nums[mid] <= nums[r]) {
                ans = Math.min(nums[mid], ans);
                r = mid - 1;
            }
        }
        return ans;
    }
}