class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int l = 0, r = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hs.put(t.charAt(i),
                hs.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> need = new HashMap<>();
        while (r < s.length()) {
            char ch = s.charAt(r);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
            boolean valid = true;
            for (char c : hs.keySet()) {
                if (need.getOrDefault(c, 0) < hs.get(c)) {
                    valid = false;
                    break;
                }
            }
            while (valid) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                need.put(leftChar, need.get(leftChar) - 1);
                l++;
                valid = true;
                for (char c : hs.keySet()) {
                    if (need.getOrDefault(c, 0) < hs.get(c)) {
                        valid = false;
                        break;
                    }
                }
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE
            ? ""
            : s.substring(start, start + minLen);
    }
}