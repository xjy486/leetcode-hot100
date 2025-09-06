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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        dummy.next = null;
        ListNode p = dummy;
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 初始化pq
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        //
        while (!pq.isEmpty()) {
            ListNode current_min = pq.poll();
            p.next = current_min;
            p = p.next;
            if (current_min.next != null) {
                pq.offer(current_min.next);
            }
        }
        return dummy.next;
    }
}