class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int l = i;
            int r = nums2.length - 1;
            int idx = 0;
            int mid = (l+r)/2;
            while (l <= r) {
                mid = (l + r) / 2;
                if (nums2[mid] < nums1[i]) {
                    r = mid - 1;
                } else if (nums2[mid] >= nums1[i]) {
                    idx = mid;
                    l = mid + 1;
                }
            }
            ans = Math.max(ans, idx-i);
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}