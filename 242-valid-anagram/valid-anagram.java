class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr = s.toCharArray();
        char[] brr = t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(brr);
        if(s.length() != t.length()) return false;
        for(int i =0 ; i < arr.length ; i++){
            if(arr[i] != brr[i]) return false;
        }
        return true;
    }
}