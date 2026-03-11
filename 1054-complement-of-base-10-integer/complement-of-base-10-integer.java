class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                s2 += '0';
            else
                s2 += '1';
        }
        return Integer.parseInt(s2, 2);
    }
}