class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] != b[1]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                });
        for (int i = 0; i < arr.length; i++) {
            int count = Integer.bitCount(arr[i]);
            pq.add(new int[] { arr[i], count });
        }
        int i = 0;
        while (!pq.isEmpty()) {
            arr[i] = pq.poll()[0];
            i++;
        }
        return arr;
    }
}