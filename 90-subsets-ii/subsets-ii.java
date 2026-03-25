class Solution {
    public void f(int[] nums, List<List<Integer>> ans, int i, List<Integer> demo) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(demo));
            return;
        }
        demo.add(nums[i]);
        f(nums, ans, i + 1, demo);
        demo.remove(demo.size() - 1);
        int idx = i;
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        f(nums, ans, idx + 1, demo);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, ans, 0, new ArrayList<>());
        return ans;
    }
}