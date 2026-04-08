class Solution {
    // public int f(int[] a, boolean[] b, int idx) {

    // }

    public int maxJump(int[] stones) {
        // 
        int max = Integer.MIN_VALUE;
        if (stones.length == 2) {
            return stones[1] - stones[0];
        }
        for (int i = 0; i < stones.length - 2; i++) {
            max = Math.max(max, stones[i + 2] - stones[i]);
        }
        return max;
    }
}