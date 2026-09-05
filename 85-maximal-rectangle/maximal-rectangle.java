class Solution {
    public int[] nse(int[] hist) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int[] nsee = new int[hist.length];
        for (int i = hist.length - 1; i >= 0; i--) {
            while (st.peek() != -1 && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.peek() == -1) {
                nsee[i] = hist.length;
            } else {
                nsee[i] = st.peek();
            }
            st.push(i);
        }
        return nsee;
    }

    public int[] pse(int[] hist) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int[] psee = new int[hist.length];
        for (int i = 0; i < psee.length; i++) {
            while (st.peek() != -1 && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.peek() == -1) {
                psee[i] = -1;
            } else {
                psee[i] = st.peek();
            }
            st.push(i);
        }
        return psee;
    }

    public int area(int[] hist) {
        int nse[] = nse(hist);
        int pse[] = pse(hist);
        int ans = 0;
        for (int i = 0; i < nse.length; i++) {
            int width = nse[i] - pse[i] - 1;
            int height = hist[i];
            ans = Math.max(ans, width * height);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] hist = new int[matrix[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    hist[j]++;
                } else
                    hist[j] = 0;
            }
            ans = Math.max(ans, area(hist));
        }
        return ans;
    }
}