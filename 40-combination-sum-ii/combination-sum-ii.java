class Solution {
    public void f(HashSet<List<Integer>> ans, int[] x, int t, int idx, List<Integer> demo) {
        if (t == 0) {
            ans.add(new ArrayList<>(demo));
            return;
        }
        if (x.length == idx || t < 0) {
            return;
        }
        
        demo.add(x[idx]);
        f(ans, x, t - x[idx], idx + 1, demo);
        demo.remove(demo.size() - 1);
        int i = idx;
        while (i + 1 < x.length && x[i + 1] == x[idx]) {
            i++;
        }
        f(ans, x, t, i + 1, demo);
    }

    public List<List<Integer>> combinationSum2(int[] x, int t) {
        Arrays.sort(x);
        HashSet<List<Integer>> ans = new HashSet<>();
        f(ans, x, t, 0, new ArrayList<>());
        List<List<Integer>> real = new ArrayList<>();
        Iterator<List<Integer>> it = ans.iterator();

        while (it.hasNext()) {
            real.add(new ArrayList<>(it.next()));
            it.remove();
        }
        return real;
    }
}