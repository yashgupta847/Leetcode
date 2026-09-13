class Solution {
    public long shadowPairs(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        int[] nse = new int[n];
        st.push(n);

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() &&
                    st.peek() != n &&
                    nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            nse[i] = st.peek();
            st.push(i);
        }

        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hs.containsKey(nums[i])) {
                hs.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> adj = new ArrayList<>();
                adj.add(i);
                hs.put(nums[i], adj);
            }
        }

        long actualAns = 0;

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> list = hs.get(nums[i]);

            int left = upperBound(list, i);

            int right = lowerBound(list, nse[i]);

            int equal = right - left;

            int total = nse[i] - i - 1;

            int greater = total - equal;

            actualAns += greater;
        }
        return actualAns;
    }

    static int upperBound(ArrayList<Integer> list, int target) {

        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    static int lowerBound(ArrayList<Integer> list, int target) {

        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}