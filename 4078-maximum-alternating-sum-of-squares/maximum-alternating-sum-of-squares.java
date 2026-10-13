class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        
        long ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            ans -= nums[l] * nums[l];
            ans += nums[r] * nums[r];
            l++;
            r--;
        }
        if (nums.length % 2 != 0) {
            ans += nums[l]*nums[l];
        }
        return ans;
    }
}