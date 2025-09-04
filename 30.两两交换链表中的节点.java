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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // head指向当前链表的第二个节点
        head = dummy.next.next;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode p1 = prev.next;
            ListNode p2 = prev.next.next;

            // swap
            prev.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            // update
            prev = p1;
        }
        return head;
    }
}