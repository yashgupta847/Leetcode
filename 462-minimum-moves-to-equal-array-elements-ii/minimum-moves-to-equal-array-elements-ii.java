class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        // if (nums.length % 2 != 0) {

        for (int i = 0; i < nums.length / 2; i++) {
            ans += (nums[nums.length / 2] - nums[i]);
        }
        for (int i = 1 + nums.length / 2; i < nums.length; i++) {
            ans += (nums[i] - nums[nums.length / 2]);
        }
        return ans;
        // } else {

        //     for (int i = 0; i < nums.length / 2; i++) {
        //         ans += (nums[nums.length / 2] - nums[i]);
        //     }
        //     for (int i = 1 + nums.length / 2; i < nums.length; i++) {
        //         ans += (nums[i] - nums[nums.length / 2]);
        //     }
        //     return ans;
        // }

    }
}