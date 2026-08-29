class Solution {
    public String[] largestString(int[] nums) {
        String ans[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = solve(nums[i]);
        }
        return ans;
    }

    public String solve(int x) {
        String s = Integer.toBinaryString(x);
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                int power = s.length() - 1 - i;
                if (power <= 25) {
                    st.append((char) ('a' + power));
                } else {
                    int count = 1 << (power - 25);
                    for (int j = 0; j < count; j++) {
                        st.append('z');
                    }
                }
            }
        }
        return st.toString();
    }
}