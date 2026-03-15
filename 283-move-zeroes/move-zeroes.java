class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                int i = j + 1;
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }
                if (i == nums.length)
                    return;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            j++;
        }

    }
}