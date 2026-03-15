class Solution {
    public int removeDuplicates(int[] nums) {
        // int[] freq = new int[nums[nums.length - 1] + 1];
        // for (int i = 0; i < nums.length; i++) {
        //     freq[nums[i]]++;
        // }
        int j = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (freq[nums[i]] > 0) {
        //         freq[nums[i]] = 0;
        //         nums[j] = nums[i];
        //         j++;
        //     }
        // }
        // return j;
        int i = 0;
        while (i < nums.length) {
            nums[j] = nums[i];
            while (i < nums.length && nums[i] == nums[j]) {
                i++;
            }
            j++;
        }
        return j;
    }
}