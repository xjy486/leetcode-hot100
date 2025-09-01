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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode reverse = head;
        reverse.next = null;
        // 头插法
        while (p != null) {
            ListNode temp = p.next;
            p.next = reverse;
            reverse = p;
            p = temp;
        }
        return reverse;
    }
}