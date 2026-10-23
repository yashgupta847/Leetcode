class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int a = q.remove();
            List<Integer> get = rooms.get(a);
            for(int i = 0 ; i< get.size() ; i++){
                if(!visited[get.get(i)]){
                    q.add(get.get(i));
                    visited[get.get(i)] = true;
                }
            }
        } 
        for(int i = 0 ; i < visited.length; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}