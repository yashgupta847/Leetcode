class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int idx = 0;
        for (int i = 0; i < cost.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                idx = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? idx : -1;
    }
}