class Solution {
    public int maxProduct(int[] nums) {
        int p1 = 1;
        int p2 = 1;
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MIN_VALUE;
        while (l < nums.length && r >= 0) {
            p1 *= nums[l++];
            p2 *= nums[r--];
            ans = Math.max(ans, Math.max(p1, p2));
            if (p1 == 0)
                p1 = 1;
            if (p2 == 0)
                p2 = 1;
        }
        return ans;
    }
}