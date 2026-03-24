class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        f(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void f(int[] n, int target, int idx, List<List<Integer>> ans, List<Integer> res) {

        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if (idx == n.length || target < 0)
            return;

        res.add(n[idx]);
        f(n, target - n[idx], idx + 1, ans, res);
        res.remove(res.size() - 1);

        int nextIdx = idx;
        while (nextIdx + 1 < n.length && n[nextIdx] == n[nextIdx + 1]) {
            nextIdx++;
        }

        f(n, target, nextIdx + 1, ans, res);
    }
}