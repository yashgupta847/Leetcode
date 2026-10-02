class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] m : meetings) {
            int u = m[0];
            int v = m[1];
            int time = m[2];

            adj.get(u).add(new int[] { v, time });
            adj.get(v).add(new int[] { u, time });
        }

        adj.get(0).add(new int[] { firstPerson, 0 });
        adj.get(firstPerson).add(new int[] { 0, 0 });

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);

        earliest[0] = 0;
        earliest[firstPerson] = 0;
        q.add(new int[] { 0, 0 });
        q.add(new int[] { firstPerson, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int person = cur[0];
            int time = cur[1];
            if (time != earliest[person])
                continue;
            ans.add(person);
            for (int[] next : adj.get(person)) {
                int neighbor = next[0];
                int meetingTime = next[1];
                if (meetingTime >= time &&
                        meetingTime < earliest[neighbor]) {
                    earliest[neighbor] = meetingTime;
                    q.add(new int[] {
                            neighbor,
                            meetingTime
                    });
                }
            }
        }

        return ans;
    }
}