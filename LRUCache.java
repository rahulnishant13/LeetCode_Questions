import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    private static Node head, tail;
    private static Map<Integer, Node> cacheMap = new HashMap<>();
    private static int cacheSize = 4;

    public static void main(String[] args) {
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;

        put(3);
        printList();
        put(2);
        printList();
        put(1);
        printList();
        getFroamCache(2);
        printList();
        put(2);
        printList();
        put(4);
        printList();
        put(6);
        printList();
        put(7);
        printList();
        getFroamCache(2);
        printList();
        put(6);
        printList();
        put(4);
        printList();
    }


    private static void printList(){
        Node node =  head;
        node = node.next;
        while (node != tail){
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }

    private static void put(int key){
        if(cacheMap.containsKey(key)){
            Node result = cacheMap.get(key);
            moveToTop(result);
//            System.out.println("data inserted : " + result.data);
        } else {
            if(cacheMap.size() < cacheSize){
                Node node = insertAtHead(key);
                cacheMap.put(key, node);
//                System.out.println("data inserted : " + node.data);
            } else {
                removeAtLast();
                Node node = insertAtHead(key);
                cacheMap.put(key, node);
//                System.out.println("data inserted : " + node.data);
            }
        }
    }

    private static int getFroamCache(int key){
        if(cacheMap.containsKey(key)){
            Node result = cacheMap.get(key);
            moveToTop(result);
            return result.data;
        } else {
            return -1;
        }
    }

    private static Node insertAtHead(int d){
        Node node =  new Node(d);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return node;
    }

    private static void removeAtLast(){
        Node toDelete = tail.prev;
        toDelete.prev.next = tail;
        tail.prev = toDelete.prev;
    }

    private static void moveToTop(Node node){
//        System.out.println(" check  " + head.data);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
