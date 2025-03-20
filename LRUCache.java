// 146. LRU Cache
// https://leetcode.com/problems/lru-cache/description/

class LRUCache {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Map<Integer, Node> lruMap = new HashMap<>();;
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        return -1;
    }

    private void insert(Node data){
        // Node temp = head.next;
        
        data.next = head.next;
        data.prev = head;

        head.next.prev = data;
        head.next = data;
    }

    private void remove(Node data){
        data.prev.next = data.next;
        data.next.prev = data.prev;
    }
    
    public void put(int key, int value) {
        Node node = lruMap.get(key);
        if(node != null) {
            node.value = value;
            lruMap.put(key, node);
            remove(node);
            insert(node);
        } else {
            Node data = new Node(key, value);
            lruMap.put(key, data);
            insert(data);

            if(lruMap.size() > capacity) {
                Node last = tail.prev;
                remove(last);
                lruMap.remove(last.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
