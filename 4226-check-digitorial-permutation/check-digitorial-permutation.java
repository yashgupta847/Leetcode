class Solution {
    public boolean isDigitorialPermutation(int n) {
        int fact[] = new int[10];
        fact[0] = 1;
        for (int i = 1; i <= 9; i++) {
            fact[i] = fact[i - 1] * i;
        }
        int sum = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            int n1 = s.charAt(i) - '0';
            sum += fact[n1];
        }
        int[] freq = new int[10];
        for(int i = 0 ; i < s.length() ;i++){
            freq[s.charAt(i)-'0']++;
        }
        int[] freq2 = new int[10];
        String s2 = Integer.toString(sum);
        if(s.length() != s2.length()) return false;
        for(int i = 0 ; i < s2.length() ;i++){
            freq2[s2.charAt(i)-'0']++;
        }
        for(int i = 0; i < s2.length() ;i++){
            int n2 = s.charAt(i)-'0';
           if(freq2[n2] != freq[n2]) return false;
        }
        return true;
    }
}
