class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] a = new int[26];
        // int[] b = new int[26];
        for (int i = 0; i < s1.length(); i = i + 2) {
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0)
                return false;
        }
        for (int i = 1; i < s1.length(); i = i + 2) {
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0)
                return false;
        }
        return true;
    }
}