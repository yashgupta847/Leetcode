class Solution {
    public int getMaximumGenerated(int n) {
        // int max = 1;
        // int prev1 = 0;
        // int prev2 = 1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        if (n % 2 != 0) {
            for (int i = 1; i <= n / 2; i++) {
                arr[2 * i] = arr[i];
                arr[2 * i + 1] = arr[i] + arr[i + 1];
            }
        } else {
            for (int i = 1; i <= n / 2 - 1; i++) {
                arr[2 * i] = arr[i];
                arr[2 * i + 1] = arr[i] + arr[i + 1];
            }
        }
        int max = 1;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}