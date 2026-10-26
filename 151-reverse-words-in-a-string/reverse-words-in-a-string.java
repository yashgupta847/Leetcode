class Solution {
    public String reverseWords(String s) {
        StringBuilder st = new StringBuilder();
        int idx = s.length() - 1;
        while (s.charAt(idx) == ' ') {
            idx--;
        }
        int i = idx;
        while (i >= 0) {
            StringBuilder temp = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                i--;
            }
            temp.reverse();
            boolean justOnce = false;
            while (i >= 0 && s.charAt(i) == ' ') {

                if (s.charAt(i) == ' ' && !justOnce) {
                    temp.append(s.charAt(i));
                    justOnce = true;

                } 
                i--;

            }
            st.append(temp);
        }
        return st.toString().trim();
    }
}