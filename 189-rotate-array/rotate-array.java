class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;
        int n = nums.length;
        int l = 0;
        int r = n - k - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = n - k;
        r = n - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}