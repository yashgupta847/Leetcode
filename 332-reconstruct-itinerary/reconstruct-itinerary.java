class Solution {
    HashMap<String, PriorityQueue<String>> hs;
    List<String> ans;

    void dfs(String src) {
        while (hs.containsKey(src) && !hs.get(src).isEmpty()) {
            String next = hs.get(src).poll();
            dfs(next);
        }

        ans.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        hs = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {

            String u = tickets.get(i).get(0);
            String v = tickets.get(i).get(1);

            hs.computeIfAbsent(u, k -> new PriorityQueue<>()).add(v);
        }
        ans = new ArrayList<>();
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
}