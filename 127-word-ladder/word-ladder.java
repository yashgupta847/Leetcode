class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[] { beginWord, "1" });
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            hs.add(wordList.get(i));
        }
        while (!q.isEmpty()) {
            String[] arr = q.remove();
            String a = arr[0];
            int now = Integer.parseInt(arr[1]);
            if (a.equals(endWord))
                return now;

            for (int i = 0; i < a.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    StringBuilder st = new StringBuilder(a);
                    if (j != st.charAt(i)) {
                        st.setCharAt(i, j);
                        if (hs.contains(st.toString())) {
                            q.add(new String[] { st.toString(), String.valueOf(now + 1) });
                            hs.remove(st.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }
}