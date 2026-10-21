class Solution {
    public boolean alreadySorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - 'a' > s.charAt(i + 1) - 'a')
                return false;
        }
        return true;
    }

    public int minOperations(String s) {
        if (alreadySorted(s)) {
            return 0;
        } else if (s.length() == 2 && !alreadySorted(s)) {
            return -1;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String p = new String(arr);
        char max = p.charAt(p.length() - 1);
        char min = p.charAt(0);
        if (s.charAt(0) == min || s.charAt(s.length() - 1) == max) {
            return 1;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        return 3;

    }
}