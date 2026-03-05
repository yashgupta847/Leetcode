class Solution {
    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid;
        int arr[] = new int[2];
        Arrays.fill(arr, -1);
        if (nums.length == 0)
            return arr;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] { 0, 0 };
            }
        }
        while (high >= low) {
            mid = (low + high) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    arr[0] = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        int idx = arr[0];
        if (idx == -1)
            return new int[] { -1, -1 };
        while (idx < nums.length && nums[idx] == target) {
            arr[1] = idx;
            idx++;
        }
        return arr;
    }
}