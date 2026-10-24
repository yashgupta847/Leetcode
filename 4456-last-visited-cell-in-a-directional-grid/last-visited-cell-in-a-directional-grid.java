class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        char dir = grid[0][0];
        if(grid.length == 1 && grid[0].length == 1) return new int[]{0,0};
        int x = -1;
        int y = -1;
        if (dir == 'R') {
            x = 0;
            y = 1;
        } else if (dir == 'D') {
            x = 1;
            y = 0;
        } else
            return new int[] { 0, 0 };
        int prevX = x;
        int prevY = y;
        while (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]) {
            char nextDir = grid[x][y];
            prevX = x;
            prevY = y;
            if (nextDir == 'R') {
                x = x;
                y = y + 1;
            } else if (nextDir == 'L') {
                y = y - 1;
                x = x;
            } else if (nextDir == 'U') {
                x -= 1;
                y = y;
            } else {
                x += 1;
                y = y;
            }
            visited[prevX][prevY] = true;
        }
        return new int[] { prevX, prevY };
    }
}