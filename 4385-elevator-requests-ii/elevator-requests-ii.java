class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        Set<Integer> uniqueFloors = new HashSet<>();
        for (int r : requests) {
            uniqueFloors.add(r);
        }
        uniqueFloors.add(start);
        List<Integer> floors = new ArrayList<>(uniqueFloors);
        Collections.sort(floors);
        int m = floors.size();
        int startIndex = Collections.binarySearch(floors, start);
        long[][][] memo = new long[m][m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(memo[i][j], -1L);
            }
        }
        return explore(startIndex, startIndex, 0, floors , memo);
    }
    private long explore(int left, int right, int pos, List<Integer> floors , long[][][] dp) {
        int m = floors.size();
        
        if (left == 0 && right == m - 1) {
            return 0; 
        }
        if(dp[left][right][pos]!=-1) return dp[left][right][pos];

        int currentFloor = (pos == 0) ? floors.get(left) : floors.get(right);
        int remainingRequests = m - (right - left + 1);
        long minPenalty = Long.MAX_VALUE;
        
        if (left > 0) {
            long distance = Math.abs(currentFloor - floors.get(left - 1));
            long cost = distance * remainingRequests;
            minPenalty = Math.min(minPenalty, cost + explore(left - 1, right, 0, floors , dp));
        }
        if (right < m - 1) {
            long distance = Math.abs(currentFloor - floors.get(right + 1));
            long cost = distance * remainingRequests;
            minPenalty = Math.min(minPenalty, cost + explore(left, right + 1, 1, floors , dp));
        }
        return dp[left][right][pos] = minPenalty;
    }
}