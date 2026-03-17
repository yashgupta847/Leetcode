class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        solve(nums, nums.length - 1);
        return ans;
    }

    public int[] solve(int[] nums, int i) {
        if (i == 0) {
            ans = nums[0];
            return new int[]{nums[0], nums[0]};
        }

        int[] prev = solve(nums, i - 1);

        int maxPrev = prev[0];
        int minPrev = prev[1];

        int curr = nums[i];

        int maxCurr = Math.max(curr, Math.max(curr * maxPrev, curr * minPrev));
        int minCurr = Math.min(curr, Math.min(curr * maxPrev, curr * minPrev));

        ans = Math.max(ans, maxCurr);

        return new int[]{maxCurr, minCurr};
    }
}