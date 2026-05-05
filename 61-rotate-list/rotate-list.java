class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int n = 1;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        k = k % n;
        if (k == 0) return head;
        temp.next = head;
        int now = n - k;
        ListNode nowNext = head;
        for (int i = 1; i < now; i++) {
            nowNext = nowNext.next;
        }
        ListNode newHead = nowNext.next;
        nowNext.next = null;

        return newHead;
    }
}