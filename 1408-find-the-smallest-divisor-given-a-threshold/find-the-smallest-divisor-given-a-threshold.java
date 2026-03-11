
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int ans = Integer.MAX_VALUE;
        int l = 1;
        int r = max;
        // for (int i = 1; i <= max; i++) {
        int sum = 0;
        //     for (int j = 0; j < nums.length; j++) {
        //         sum += Math.ceil((double) nums[j] / i);
        //     }
        //     if (sum <= threshold) {
        //         ans = Math.min(ans, i);
        //     }
        // }
        while (l <= r) {
            int mid = (l + r) / 2;
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += Math.ceil((double) nums[j] / mid);
            }
            if (sum <= threshold) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
}