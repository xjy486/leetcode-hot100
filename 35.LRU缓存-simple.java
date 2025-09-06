import java.util.HashMap;

class LRUCache {
    // Inner class for the Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    // Helper methods to simplify list manipulation
    /** Adds a node right after the head (most recent). */
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /** Removes a node from anywhere in the list. */
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    /** A quick way to move a node to the front. */
    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Main LRUCache properties
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head; // Dummy head
    private Node tail; // Dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize sentinel nodes
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1; // Not found
        }

        // Found it, move it to the front
        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            // It's a new key
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            map.put(key, newNode);
            addNode(newNode);

            // Check if we've exceeded capacity
            if (map.size() > capacity) {
                // Evict the least recently used item (the one before the tail)
                Node tailPrev = tail.prev;
                removeNode(tailPrev);
                map.remove(tailPrev.key);
            }
        } else {
            // It's an existing key, update value and move to front
            node.value = value;
            moveToFront(node);
        }
    }
}