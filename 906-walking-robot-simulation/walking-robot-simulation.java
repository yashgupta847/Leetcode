class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        int x = 0, y = 0;
        int max = 0;

        int up = 1, down = 0, left = 0, right = 0;
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            hs.add(Arrays.asList(obstacles[i][0], obstacles[i][1]));
        }

        for (int i = 0; i < commands.length; i++) {
            int now = commands[i];

            if (1 <= now && now <= 9) {

                for (int step = 0; step < now; step++) {

                    int nx = x, ny = y;

                    if (up == 1)
                        ny++;
                    else if (down == 1)
                        ny--;
                    else if (left == 1)
                        nx--;
                    else
                        nx++;
                    if (hs.contains(Arrays.asList(nx, ny))) {
                        break;
                    }
                    x = nx;
                    y = ny;

                    max = Math.max(max, x * x + y * y);
                }
            } else if (now == -1) {
                if (up == 1) {
                    up = 0;
                    right = 1;
                } else if (right == 1) {
                    right = 0;
                    down = 1;
                } else if (down == 1) {
                    down = 0;
                    left = 1;
                } else {
                    left = 0;
                    up = 1;
                }

            } else {
                if (up == 1) {
                    up = 0;
                    left = 1;
                } else if (left == 1) {
                    left = 0;
                    down = 1;
                } else if (down == 1) {
                    down = 0;
                    right = 1;
                } else {
                    right = 0;
                    up = 1;
                }
            }
        }

        return max;
    }
}