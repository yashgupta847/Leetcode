class Solution {
    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        int l = 0;
        int r = s1.length() - 1;
        for (int i = l; i < r; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }
        while (r < s2.length()) {
            freq2[s2.charAt(r) - 'a']++;
            if (Arrays.equals(freq1, freq2))
                return true;
            else {
                freq2[s2.charAt(l) - 'a']--;
                l++;
                r++;
            }
        }
        return false;
    }
}