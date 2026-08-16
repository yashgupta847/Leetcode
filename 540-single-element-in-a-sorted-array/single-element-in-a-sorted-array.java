class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0;
        int r = nums.length - 1;
        if (l + 1 < nums.length) {
            if (nums[l + 1] == nums[l]) {
                l++;
            } else
                return nums[l];
        }
        if (r - 1 >= 0) {
            if (nums[r] == nums[r - 1]) {
                r--;
            } else
                return nums[r];
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid] == nums[mid + 1]) {
                if ((mid + 1) % 2 == 0) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            }
        }
        return nums[l];
    }
}
