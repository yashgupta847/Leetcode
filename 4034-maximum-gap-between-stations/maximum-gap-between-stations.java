class Solution {
    public int maximumGap(String skill, String station) {

        int n = skill.length();
        int m = station.length();

        if (n == 1) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {

            while (station.charAt(j) != skill.charAt(i)) {
                j++;
            }

            left[i] = j;
            j++;
        }
        j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            while (station.charAt(j) != skill.charAt(i)) {
                j--;
            }

            right[i] = j;
            j--;
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {

            ans = Math.max(ans, right[i + 1] - left[i]);
        }

        return ans;
    }
}