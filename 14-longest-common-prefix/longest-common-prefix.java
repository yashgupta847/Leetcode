class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length -1];
        int l = 0;
        int r = 0;
        String ans = "";
        while(l < a.length() && r < b.length()){
            if(a.charAt(l) == b.charAt(r)){
                ans += a.charAt(l);
            } else break;
            l++;
            r++;
        }
        return ans;
    }
}
