class Solution {
    public int[] countOppositeParity(int[] nums) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % 2 != nums[i] % 2)
                    cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}