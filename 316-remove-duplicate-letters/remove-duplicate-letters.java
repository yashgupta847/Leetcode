class Solution {
    public String removeDuplicateLetters(String s) {
        int[] countF = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            countF[a]++;
        }
        StringBuilder st = new StringBuilder();
        boolean[] visit = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            countF[s.charAt(i) - 'a']--;
            if (visit[s.charAt(i) - 'a']) {
                
                continue;
            }
            while (st.length() > 0 && (st.charAt(st.length() - 1) - 'a') > (s.charAt(i) - 'a')
                    && countF[st.charAt(st.length() - 1) - 'a'] > 0) {
                
                visit[st.charAt(st.length()-1)-'a'] = false;
                st.deleteCharAt(st.length() - 1);
            }
            st.append(s.charAt(i));
            visit[s.charAt(i) - 'a'] = true;
        }
        return st.toString();
    }
}