package LeetCode_Questions;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head, next = head.next;

        while(current != null){
            int val = current.val;
            while(next != null && next.val == val){
                next = next.next;
            }
            current.next = next;
            current = current.next;
        }

        return head;
    }
}

// =========================================================================================================

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode baba = head;
        while (baba != null){
            System.out.print(baba.val + " ");
            baba = baba.next;
        }

        System.out.println();

        head = deleteDuplicates(head);

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode sHead = new ListNode();
        ListNode sTail = sHead;

        while (head != null) {
            int val = head.val;
            if (head.next != null && val == head.next.val) {
                while (head.next != null && val == head.next.val) {
                    head = head.next;
                }
            }
            ListNode next = head.next;
            head.next = null;
            sTail.next = head;
            sTail = head;
            head = next;
        }
        return sHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

