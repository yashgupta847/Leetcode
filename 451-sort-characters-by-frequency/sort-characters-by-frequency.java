class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() 
        );

        pq.addAll(map.entrySet());

        while(!pq.isEmpty()){
            Map.Entry<Character , Integer> m = pq.remove();
            ans.append(String.valueOf(m.getKey()).repeat(m.getValue()));
        }
        return ans.toString();
    }
}