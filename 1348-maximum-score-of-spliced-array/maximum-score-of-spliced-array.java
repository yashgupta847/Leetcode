class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int x : nums1) sum1 += x;
        for (int x : nums2) sum2 += x;

        int gain1 = kadane(nums2, nums1);
        int gain2 = kadane(nums1, nums2);
        return Math.max(sum1 + gain1, sum2 + gain2);
    }
    private int kadane(int[] a, int[] b) {
        int maxSoFar = 0, curr = 0;
        for (int i = 0; i < a.length; i++) {
            int diff = a[i] - b[i];
            curr = Math.max(diff, curr + diff);
            maxSoFar = Math.max(maxSoFar, curr);
        }

        return maxSoFar;
    }
}