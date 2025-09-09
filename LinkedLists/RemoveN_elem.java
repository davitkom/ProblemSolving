class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // move first n+1 steps ahead
        for (int i = 0; i <= n; i++) first = first.next;

        // move both until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // remove nth node
        second.next = second.next.next;
        return dummy.next;
    }
}
