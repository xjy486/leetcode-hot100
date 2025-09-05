/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/*
 * 使用哈希表来存储原节点和新节点的映射关系
 * 然后再遍历一遍链表，设置新节点的next和random指针
 */
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node p_copy = new Node(p.val);
            map.put(p, p_copy);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node p_copy = map.get(p);
            p_copy.next = map.getOrDefault(p.next, null);
            p_copy.random = map.getOrDefault(p.random, null);
            p = p.next;
        }
        return map.get(head);
    }
}