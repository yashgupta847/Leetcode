class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < capacity.length; i++) {
            if (ans > capacity[i] && capacity[i] >= itemSize) {
                ans = capacity[i];
                idx = i;
            }
        }
        return idx;
    }
}