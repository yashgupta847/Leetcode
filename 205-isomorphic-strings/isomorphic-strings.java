class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hs = new HashMap<>();
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.containsKey(s.charAt(i))) {
                if (hs.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                } 
            } else {
                if(hash.contains(t.charAt(i))) return false;
                hs.put(s.charAt(i), t.charAt(i));
                hash.add(t.charAt(i));
            }
        }
        return true;
    }
}