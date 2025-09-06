class LRUCache {
    class LinkedList {
        int key;
        int value;
        LinkedList prev;
        LinkedList next;
    }

    LinkedList head = new LinkedList();
    LinkedList tail = new LinkedList();
    HashMap<Integer, LinkedList> map = new HashMap<>();
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head.next = tail;
        this.head.prev = null;
        this.tail.next = null;
        this.tail.prev = head;
    }

    public int get(int key) {
        LinkedList node = map.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        // 1 更新在链表中的位置
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return node.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            LinkedList node = map.getOrDefault(key, null);
            node.value = value;
            return;
        }
        // 2 LRUCache中没有这个元素

        LinkedList node = new LinkedList();
        node.key = key;
        node.value = value;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(key, node);
        count++;
        if (count > capacity) {
            LinkedList node_t = tail.prev;

            tail.prev = node_t.prev;
            node_t.prev.next = tail;
            count = capacity;
            map.remove(node_t.key);

        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */