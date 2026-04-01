class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4]; 
        for (int i = 0; i < n; i++) {
            robots[i] = new int[]{positions[i], healths[i], directions.charAt(i), i};
        }
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek()[2] == 'R') {
                    if (stack.peek()[1] < robot[1]) {
                        stack.pop();
                        robot[1]--;
                    } else if (stack.peek()[1] > robot[1]) {
                        stack.peek()[1]--;
                        robot[1] = 0;
                        break;
                    } else {
                        stack.pop();
                        robot[1] = 0;
                        break;
                    }
                }
                if (robot[1] > 0) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> survivors = new ArrayList<>(stack);
        Collections.sort(survivors, (a, b) -> a[3] - b[3]);

        List<Integer> result = new ArrayList<>();
        for (int[] r : survivors) {
            result.add(r[1]);
        }

        return result;
    }
}