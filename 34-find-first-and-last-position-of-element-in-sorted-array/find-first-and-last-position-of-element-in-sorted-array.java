class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int arr[] = new int[2];
        Arrays.fill(arr, -1);
        while (high >= low) {
            mid = (low + high) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    arr[0] = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        high = nums.length - 1;
        low = 0;
        if (arr[0] != -1) {
            while (high >= low) {
                mid = (low + high) / 2;
                if (nums[mid] <= target) {
                    if (nums[mid] == target)
                        arr[1] = mid;
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return arr;
    }
}