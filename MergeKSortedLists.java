package LeetCode_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode result = new ListNode();
        ListNode head = result;

        for (ListNode list : lists) {
            if(list != null)
                pq.add(list);
        }

        while (!pq.isEmpty()){
            result.next = pq.poll();
            result = result.next;
            if(result.next != null)
                pq.add(result.next);
        }

        return head.next;
    }

//    private static ListNode mergeSortKLists(ListNode[] lists) {
//        if(lists.length == 0){
//            return null;
//        }
//
//    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}