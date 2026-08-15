class Solution {
    public void f(int[] nums, int idx, List<List<Integer>> ans, ArrayList<Integer> demo) {
        if (idx == -1) {
            ans.add(new ArrayList<>(demo));
            return;
        }
        demo.add(nums[idx]);
        f(nums, idx - 1, ans, demo);
        demo.remove(demo.size() - 1);
        f(nums, idx - 1, ans, demo);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, nums.length - 1, ans, new ArrayList<>());
        return ans;
    }
}