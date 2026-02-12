class Solution {
    public boolean isB(int[] freq){
        int count = 0;
        int expected = 0;
        for(int f : freq){
            if(f>0){
                if(expected == 0) expected = f;
                else if(expected != f) return false;
                count++;
            }
        }
        return count>0;
    }
    public int longestBalanced(String s) {
        String d = s;
        int n = s.length();
        int ans = 0;
        for(int i =0 ; i < n ; i++){
            int[] freq = new int[26];
            for(int j = i ; j < n ; j ++){
                freq[d.charAt(j) - 'a']++;
                if(isB(freq)) ans = Math.max(ans , j-i+1);
                
            }
        }
        return ans;
    }
}