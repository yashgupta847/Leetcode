class Solution {
    public int calculateScore(int a, int b) {
        String a1 = Integer.toBinaryString(a);
        String a2 = Integer.toBinaryString(b);
        int set1 = 0;
        int set2 = 0;
        for (int i = 0; i < a1.length(); i++) {
            if (a1.charAt(i) == '1') {
                set1++;
            }
        }
        for (int i = 0; i < a2.length(); i++) {
            if (a2.charAt(i) == '1') {
                set2++;
            }
        }
        if (set1 >= set2) {
            return set1 * set2;
        }
        return set2 / set1;
    }
}