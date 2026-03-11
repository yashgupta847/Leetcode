class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums.length <= 3) {
            if (nums[l] == nums[r])
                return nums[l];
            else {
                if (nums[l] == nums[l + 1])
                    return nums[r];
                else
                    return nums[l];
            }
        }
        l = 1;
        r = nums.length - 2;
        if (nums[l] != nums[0])
            return nums[0];
        else if (nums[r] != nums[nums.length - 1])
            return nums[nums.length - 1];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            if (nums[mid] == nums[mid + 1]) {
                if ((mid + 1) % 2 != 0) {
                    l = mid + 1;
                } else
                    r = mid - 1;
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