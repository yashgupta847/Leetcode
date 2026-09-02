class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder st = new StringBuilder(number);
        int index = -1;
        for(int i = 0 ; i < number.length() ; i++){
            
            if(number.charAt(i) == digit){
                index = i;
                if(number.length() > i+1 && number.charAt(i+1) > digit){
                    break;
                }
            }
            
        }
        st.deleteCharAt(index);
        return st.toString();
    }
}