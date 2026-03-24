class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hs = new HashMap<>();
        hs.put('2', "abc");
        hs.put('3', "def");
        hs.put('4', "ghi");
        hs.put('5', "jkl");
        hs.put('6', "mno");
        hs.put('7', "pqrs");
        hs.put('8', "tuv");
        hs.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        f(digits, 0, ans, new StringBuilder() , hs);
        return ans;
    }

    public void f(String digits, int idx, List<String> ans, StringBuilder st, HashMap<Character, String> hs) {
        if (idx == digits.length()) {
            ans.add(st.toString());
            return;
        }

        for (char ch : hs.get(digits.charAt(idx)).toCharArray()) {
            st.append(ch);
            f(digits, idx + 1, ans, st, hs);
            st.deleteCharAt(st.length() - 1);

        }

    }

}