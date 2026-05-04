class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[] { beginWord, "1" });
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            hs.add(wordList.get(i));
        }

        while (!q.isEmpty()) {
            String a[] = q.poll();
            String element = a[0];
            int level = Integer.parseInt(a[1]);
            if (element.equals(endWord))
                return level;
            for (int i = 0; i < element.length(); i++) {
                StringBuilder s = new StringBuilder(element);
                char ch = s.charAt(i);
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j != ch) {
                        s.setCharAt(i, j);
                        if (hs.contains(s.toString())) {
                            q.add(new String[] { s.toString(), String.valueOf(level + 1) });
                            hs.remove(s.toString());

                        }
                    }
                }
            }
        }
        return 0;
    }
}