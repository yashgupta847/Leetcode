class EventManager {
    private PriorityQueue<int[]> pq;
    private HashMap<Integer, Integer> hs;

    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0]; 
            }
            return a[1] - b[1];
        });
        hs = new HashMap<>();
        for (int i = 0; i < events.length; i++) {
            pq.offer(new int[] { events[i][1], events[i][0] });
            hs.put(events[i][0], events[i][1]);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        hs.put(eventId, newPriority);
        pq.offer(new int[] { newPriority, eventId });
    }

    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int p = top[0];
            int e = top[1];
            if (hs.containsKey(e) && hs.get(e) == p) {
                hs.remove(e);
                return e;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */