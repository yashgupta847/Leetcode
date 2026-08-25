class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int p = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) { //expired index remove
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) { //remove if get maximum for this window
                dq.removeLast();
                // dq.offerLast(i);
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                ans[p++] = nums[dq.peekFirst()];
            }

        }
        return ans;
    }
}