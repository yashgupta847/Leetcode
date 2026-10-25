class Solution {
    public long maximizeSum(int[] nums, int k) {
        long ans = 0;

        PriorityQueue<Long> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            String a = Integer.toString(num);
            char[] arr = a.toCharArray();

            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder(new String(arr));
            sb.reverse();

            long rearranged = Long.parseLong(sb.toString());
            long gain = rearranged - num;

            if (gain > 0) {
                pq.offer(gain);
            }
        }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            ans += pq.poll();
        }

        for (int num : nums) {
            ans += num;
        }

        return ans;
    }
}
