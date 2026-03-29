class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        if (cnt == 0)
            return true;
        if (cnt == 4) {
            if (s1.charAt(0) == s2.charAt(2) && s1.charAt(1) == s2.charAt(3)) {
                if (s1.charAt(2) == s2.charAt(0) && s1.charAt(3) == s2.charAt(1))
                    return true;
            }
        }
        if (cnt == 2) {
            if (s1.charAt(0) == s2.charAt(2) && s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3) && s1.charAt(2) == s2.charAt(0))
                return true;
            if (s2.charAt(3) == s1.charAt(1) && s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2) && s1.charAt(3) == s2.charAt(1))
                return true;
        }
        if (cnt % 2 != 0)
            return false;
        return false;
    }
}