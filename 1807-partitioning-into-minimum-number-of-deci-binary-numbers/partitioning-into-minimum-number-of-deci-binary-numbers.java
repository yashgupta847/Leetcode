class Solution {
    public int minPartitions(String n) {
        // int ans = 0;
        // for (int i = 0; i < n.length(); i++) {
        //     ans = Math.max(ans, n.charAt(i) - '0');
        // }
        // return ans;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(i != n.length()){
            pq.add(n.charAt(i)-'0');
            i++;
        }
        return pq.poll();
    }
}