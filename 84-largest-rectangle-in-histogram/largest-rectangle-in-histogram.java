class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int nse[] = new int[heights.length];
        s.push(-1);
        for (int i = heights.length - 1; i >= 0; i--) {

            while (s.peek() != -1 && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            if (s.peek() == -1) {
                nse[i] = heights.length;
                s.push(i);
                continue;
            }
            if (heights[i] > heights[s.peek()]) {
                nse[i] = s.peek();
            }
            s.push(i);
        }
        int pse[] = new int[heights.length];
        while (!s.isEmpty()) {
            s.pop();
        }
        s.push(-1);
        for (int i = 0; i < heights.length; i++) {

            while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.peek() == -1) {
                pse[i] = -1;
                s.push(i);
                continue;
            }
            if (heights[i] > heights[s.peek()]) {
                pse[i] = s.peek();
            }
            s.push(i);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nse.length; i++) {
            int diff = nse[i] - pse[i] - 1;
            ans = Math.max(diff * heights[i], ans);
        }
        return ans;
    }
}

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int[] nse = new int[n];
//         Stack<Integer> s = new Stack<>();
//         s.push(-1);
//         for (int i = n - 1; i >= 0; i--) {
//             while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
//                 s.pop();
//             }

//             if (s.peek() == -1)
//                 nse[i] = n;
//             else
//                 nse[i] = s.peek();

//             s.push(i);
//         }
//         int[] pse = new int[n];
//         s.clear();
//         s.push(-1);
//         for (int i = 0; i < n; i++) {
//             while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
//                 s.pop();
//             }
//             if (s.peek() == -1)
//                 pse[i] = -1;
//             else
//                 pse[i] = s.peek();

//             s.push(i);
//         }
//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             int width = nse[i] - pse[i] - 1;
//             int area = width * heights[i];
//             ans = Math.max(ans, area);
//         }
//         return ans;
//     }
// }