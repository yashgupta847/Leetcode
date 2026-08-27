class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int curr1 = Integer.MAX_VALUE;
        int curr2 = Integer.MAX_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && curr2 != nums[i]) {
                cnt1 = 1;
                curr1 = nums[i];
            } else if (cnt2 == 0 && curr1 != nums[i]) {
                cnt2 = 1;
                curr2 = nums[i];
            } else if (curr1 == nums[i]) {
                cnt1++;
            } else if (curr2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr1) {
                cnt1++;
            } else if (nums[i] == curr2)
                cnt2++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            ans.add(curr1);
        }
        if (cnt2 > nums.length / 3)
            ans.add(curr2);
        return ans;
    }
}