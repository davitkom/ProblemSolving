class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newList = new ListNode(); // dummy node
        ListNode head = newList;

        ListNode head1 = list1;
        ListNode head2 = list2;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }

        // Attach the remaining nodes
        if (head1 != null) head.next = head1;
        if (head2 != null) head.next = head2;

        return newList.next; // skip dummy node
    }
}
