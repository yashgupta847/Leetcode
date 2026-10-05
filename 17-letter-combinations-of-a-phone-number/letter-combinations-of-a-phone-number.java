class Solution {

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> hs = new HashMap<>();
        List<String> ans = new ArrayList<>();
        hs.put(2, "abc");
        hs.put(3, "def");
        hs.put(4, "ghi");
        hs.put(5, "jkl");
        hs.put(6, "mno");
        hs.put(7, "pqrs");
        hs.put(8, "tuv");
        hs.put(9, "wxyz");
        f(0, ans, hs, new StringBuilder(), digits);
        return ans;
    }

    public void f(int idx, List<String> ans, HashMap<Integer, String> hs, StringBuilder st, String digits) {
        if(idx == digits.length()) {
            ans.add(st.toString());
            return;
        }

        for (char ch : hs.get(digits.charAt(idx) - '0').toCharArray()) {
            st.append(ch);
            f(idx + 1, ans, hs, st, digits);
            st.deleteCharAt(st.length() - 1);
        }
    }
}