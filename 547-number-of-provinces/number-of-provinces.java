class Solution {
    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[isConnected.length];
        Stack<Integer> st = new Stack<>();
        int connected = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                connected += 1;
                st.add(i);
                visited[i] = true;
                while (!st.isEmpty()) {
                    int a = st.pop();
                    for (int neighb : adj.get(a)) {
                        if (!visited[neighb]) {
                            st.add(neighb);
                            visited[neighb] = true;
                        }
                    }
                }
            }
        }
        return connected;
    }
}