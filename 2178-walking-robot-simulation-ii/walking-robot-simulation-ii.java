class Robot {
    public int[][] grid;
    public int x = 0;
    public int y = 0;
    public String s = "East";
    public int w;
    public int h;

    public Robot(int width, int height) {
        grid = new int[width][height];
        w = width;
        h = height;
    }

    public void step(int num) {
        int perimeter = 2 * (w + h) - 4;
        num = num % perimeter;

        while (num > 0) {
            if (s.equals("East")) {
                int move = Math.min(num, w - 1 - x);
                x += move;
                num -= move;
                if (num > 0) s = "North";
            } else if (s.equals("North")) {
                int move = Math.min(num, h - 1 - y);
                y += move;
                num -= move;
                if (num > 0) s = "West";
            } else if (s.equals("West")) {
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (num > 0) s = "South";
            } else {
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (num > 0) s = "East";
            }
        }

        if (num == 0 && x == 0 && y == 0) {
            s = "South";
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return s;
    }
}