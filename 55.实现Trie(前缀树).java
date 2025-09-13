class Trie {
    public TrieNode root;

    class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> next;

        public TrieNode() {
            this.isEndOfWord = false;
            this.next = new HashMap<Character, TrieNode>();
        }

        public void setEnd() {
            this.isEndOfWord = true;
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = curr.next.getOrDefault(c, null);
            if (node == null) {
                node = new TrieNode();
                curr.next.put(c, node);
            }
            if (i == word.length() - 1)
                node.setEnd();
            curr = node;
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = curr.next.getOrDefault(c, null);
            if (node == null)
                return false;
            curr = node;

        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode node = curr.next.getOrDefault(c, null);
            if (node == null)
                return false;
            curr = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */