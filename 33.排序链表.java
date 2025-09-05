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
    public ListNode sortList(ListNode head) {
        // 1. 递归终止：只有一个节点，或者为空
        if (head == null || head.next == null) {
            return head;
        }
        // 2. 从中点处分割成两块
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode sorted_left = sortList(head);
        ListNode sorted_right = sortList(slow);
        // 3. 合并
        return merge(sorted_left, sorted_right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();

        ListNode p1 = left;
        ListNode p2 = right;
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }
        return dummy.next;
    }
}