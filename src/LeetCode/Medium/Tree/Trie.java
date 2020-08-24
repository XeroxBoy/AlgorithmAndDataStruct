package LeetCode.Medium.Tree;

class Trie {
    private Trie[] next = new Trie[26];
    private boolean hasChar;
    private boolean isDefinite;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        hasChar = false;
        isDefinite = false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.startsWith("a"));
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(
                trie.search("app")
        );
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie nextTrie = this;
        for (int i = 0; i < word.length(); i++) {
            char oneChar = word.charAt(i);
            if (nextTrie.next[oneChar - 'a'] == null) {
                nextTrie.next[oneChar - 'a'] = new Trie();
            }
            nextTrie = nextTrie.next[oneChar - 'a'];
            nextTrie.hasChar = true;
        }
        nextTrie.hasChar = true;
        nextTrie.isDefinite = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie nextTrie = this;
        for (int i = 0; i < word.length(); i++) {
            if (nextTrie.next[word.charAt(i) - 'a'] == null || !nextTrie.next[word.charAt(i) - 'a'].hasChar)
                return false;
            nextTrie = nextTrie.next[word.charAt(i) - 'a'];
        }
        return nextTrie.isDefinite;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie nextTrie = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (nextTrie.next[prefix.charAt(i) - 'a'] == null || !nextTrie.next[prefix.charAt(i) - 'a'].hasChar)
                return false;
            nextTrie = nextTrie.next[prefix.charAt(i) - 'a'];
        }
        return nextTrie.hasChar;
    }
}