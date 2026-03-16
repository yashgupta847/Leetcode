class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int k = 0; //(+ve)
        int p = 1; //(-ve)

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[p] = nums[i];
                p = p + 2;
            } else {
                ans[k] = nums[i];
                k += 2;
            }
        }
        return ans;
    }
}