// 460. LFU Cache
// https://leetcode.com/problems/lfu-cache/

class Node {
    int key;
    int value;
    int freq;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }
}

class LFUCache {
    TreeMap<Integer, Node[]> freqNodeMap;
    Map<Integer, Node> cacheMap;
    int maxCap;

    public LFUCache(int capacity) {
        freqNodeMap = new TreeMap();
        cacheMap = new HashMap<>();
        maxCap = capacity;
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            changeFreqOfNode(node);

            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        // if (maxCap == 0) return;

        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            changeFreqOfNode(node);
        } else {
            if(cacheMap.size() >= maxCap) {
                removeLeastLastNode();
            }
            Node newNode = new Node(key, value);
            checkFreqMapAndAdd(1, newNode);
            cacheMap.put(key, newNode);
        }
    }

    public void removeLeastLastNode() {
        int key = freqNodeMap.firstKey();
        Node[] listnode = freqNodeMap.get(key);

        Node tail = listnode[1];
        Node node = tail.prev;

        cacheMap.remove(node.key);

        tail.prev = node.prev;
        node.prev.next = tail;

        if(listnode[0] == tail.prev) {
            freqNodeMap.remove(key);
        }
    }

    public void changeFreqOfNode(Node node) {
        Node[] listNode = freqNodeMap.get(node.freq);
        if (node.prev == listNode[0] && node.next == listNode[1]) {
            freqNodeMap.remove(node.freq);
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        node.freq += 1;

        checkFreqMapAndAdd(node.freq, node);
    }

    public void checkFreqMapAndAdd(int freq, Node newNode) {
        if(freqNodeMap.containsKey(freq)) {
            Node head = freqNodeMap.get(freq)[0];
            addAtHead(head, newNode);
        } else {
            Node head = new Node(-1,-1);
            Node tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            addAtHead(head, newNode);
            freqNodeMap.put(freq, new Node[] {head, tail});
        }
    }

    public void addAtHead(Node head, Node newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
