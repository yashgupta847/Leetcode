class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>((a, b) -> b - a);
        pq2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (pq1.isEmpty() && pq2.isEmpty()) {
            pq1.add(num);
        }
        else if (num <= pq1.peek()) {
            pq1.add(num);
        } else {
            pq2.add(num);
        }
        if (pq1.size() > pq2.size() + 1) {
            pq2.add(pq1.poll());
        } else if (pq2.size() > pq1.size()) {
            pq1.add(pq2.poll());
        }
    }

    public double findMedian() {
        if (pq1.size() == pq2.size()) {
            return (pq1.peek() + pq2.peek()) / 2.0;
        } else {
            return pq1.peek();
        }
    }
}
