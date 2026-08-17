class Solution {
    // public int f(int[] nums, int idx) {

    // }

    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length; i++) {
            // res[i] = nums[i];
            for (int j = i; j < nums.length; j++) {
                res[i] *= nums[j];
                if (max < res[i])
                    max = res[i];
            }
            // if (max < res[i])
            // max = res[i];
        }
        return max;
    }
}