// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0); // dummy node
        helper.next = head;

        ListNode prev = helper;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return helper.next; // skip dummy node
    }
}
