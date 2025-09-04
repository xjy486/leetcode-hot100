/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next_group_head;
        while (true) {
            // === START of a new group ===

            // 1. Find the start and end nodes of the CURRENT group.
            // Let's say 'start' is the first node and 'end' is the k-th node.
            ListNode start = prev.next;
            ListNode end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    break;// What does it mean if 'end' becomes null here?
                }
            }
            // 2. Check: Is the group valid? (Did we find an 'end' node?)
            // If not, we have fewer than k nodes left, so we should stop.
            if (end == null) {
                break;
            }
            // 3. If the group is valid, reverse it from 'start' to 'end'.
            next_group_head = end.next;
            ListNode tail = reverse(start, end);
            // 4. Connect the reversed group back to the main list.
            prev.next = end;
            tail.next = next_group_head;
            // 5. Update 'prev' to get ready for the NEXT group.
            prev = tail;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        // 反转从start到end之间所有的节点
        ListNode p = start;
        ListNode tail = start;
        ListNode prev = null;
        while (p != end) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
        // 处理最后一个节点
        p.next = prev;
        return tail;

    }
}