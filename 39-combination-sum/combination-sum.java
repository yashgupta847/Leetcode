class Solution {
    public void f(List<List<Integer>> ans, int t, int[] c, int idx, ArrayList<Integer> demo) {
        // if(t < 0 ) return;
        if (idx == c.length)
            return;
        if (t == 0) {
            ans.add(new ArrayList<>(demo));
            return;
        }

        if (t - c[idx] >= 0) {
            demo.add(c[idx]);
            f(ans, t - c[idx], c, idx, demo);
            demo.remove(demo.size() - 1);
            f(ans, t, c, idx + 1, demo);
        }

        else {
            f(ans, t, c, idx + 1, demo);
            return;
        }

    }

    public List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(ans, target, c, 0, new ArrayList<>());
        return ans;
    }
}