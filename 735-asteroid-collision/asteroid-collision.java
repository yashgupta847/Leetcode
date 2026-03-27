class Solution {
    public int[] asteroidCollision(int[] p) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : p) {
            boolean destroyed = false;

            while (!ans.isEmpty() && x < 0 && ans.get(ans.size() - 1) > 0) {
                int last = ans.get(ans.size() - 1);
                if (last < -x) {
                    ans.remove(ans.size() - 1); 
                } else if (last == -x) {
                    ans.remove(ans.size() - 1);
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                ans.add(x);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}