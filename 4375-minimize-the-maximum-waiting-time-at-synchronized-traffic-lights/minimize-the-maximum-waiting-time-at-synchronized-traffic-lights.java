class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        Arrays.sort(lights);
        int ans = Integer.MIN_VALUE;
        int[] r = new int[arrivalTime.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = arrivalTime[i] % period;
            if (r[i] < lights[lights.length - 1])
                ans = Math.max(ans, 0);
            else {
                ans = Math.max(ans, period - r[i]);
            }
        }
        return ans;

    }
}