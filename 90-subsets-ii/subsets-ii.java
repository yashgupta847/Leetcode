class Solution {

    public void f(int[] nums, List<List<Integer>> ans, int idx, List<Integer> demo) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(demo));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            demo.add(nums[i]);
            f(nums, ans, i + 1, demo);
            demo.remove(demo.size() - 1);
            f(nums, ans, i + 1, demo);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        f(nums, ans, 0, new ArrayList<>());
        for (int i = 0; i < ans.size(); i++) {
            hs.add(new ArrayList<>(ans.get(i)));
        }
        List<List<Integer>> ans1 = new ArrayList<>();
        Iterator<List<Integer>> it = hs.iterator();
        while(it.hasNext()){
            ans1.add(new ArrayList<>(it.next()));
            it.remove();
        }
        return ans1;
    }
}