class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String word = queries[i];
            for (int j = 0; j < dictionary.length; j++) {
                String word2 = dictionary[j];
                int count = 0;
                for (int k = 0; k < word.length(); k++) {
                    if (word.charAt(k) != word2.charAt(k)) {
                        count++;
                    }
                    if (count > 2)
                        break;
                }
                if (count <= 2) {
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }
}