class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        //for (int i = 0; i < s.length(); i++) {
        int j = 0;
        while (j < s.length() && s.charAt(j) == '1') {
            j++;
            count--;
        }
        if (count == 0)
            return true;
        else
            return false;
        // }
      //  return true;
    }
}

// class Solution {
//     public boolean checkOnesSegment(String s) {
//         for(int i = 1; i < s.length(); i++){
//             if(s.charAt(i) == '1' && s.charAt(i-1) == '0'){
//                 return false;
//             }
//         }
//         return true;
//     }
// }