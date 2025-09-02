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
/*
 * 双指针，一快一慢，这样可以找到链表的中间位置，但是要注意快指针的终止条件 fast.next != null针对链表长度为奇数的情况
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // fast = fast.next;
        }
        ListNode reverse = reverseList(slow);
        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;

    }

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