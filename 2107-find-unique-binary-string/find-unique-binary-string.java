class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int n = nums.length;
        for (int i = 0; i < (1<<n); i++) {
            // for (int j = 0; j <= 1; j++) {
                String s = Integer.toBinaryString(i);
                while (s.length() < n) {
                    s = "0" + s;
                }
                if (!hs.contains(s))
                    return s;

            // }
        }
        return " ";
    }
}