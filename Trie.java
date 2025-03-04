// 208. Implement Trie (Prefix Tree)
// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children =  new HashMap<>();
        endOfWord = false;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
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
