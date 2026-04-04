class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int l = 0;
        int r = citations.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (citations[mid] >= n - mid) {
                ans = n - mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
}