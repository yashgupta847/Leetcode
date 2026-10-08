class Solution {
    boolean isvalid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty())
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            } else{
                st.pop();
                if(!st.isEmpty()){
                    ans = Math.max(ans , i - st.peek());
                } else{
                    st.push(i);
                }
            }
        }
        return ans;
    }
}