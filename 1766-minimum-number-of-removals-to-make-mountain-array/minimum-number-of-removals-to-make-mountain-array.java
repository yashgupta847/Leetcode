class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp1[j] + 1 > dp1[i])
                    dp1[i] = 1 + dp1[j];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && dp2[j] + 1 > dp2[i])
                    dp2[i] = 1 + dp2[j];
            }
        }
        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                maxMountain = Math.max(
                        maxMountain,
                        dp1[i] + dp2[i] - 1);
            }
        }

        return n - maxMountain;
    }
}