class Solution {
    public boolean isPalindromic(String s) {
        
        StringBuilder st = new StringBuilder();
        StringBuilder ps = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            int a = s.charAt(i);
            st.append(String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0'));
        }
        // for(int i = s.length() -1 ; i >= 0 ; i--){
        //     int a = s.charAt(i);
        //     ps.append(String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0'));
        // }
        if(st.toString().equals(st.reverse().toString())) return true;
        return false;
    }
}