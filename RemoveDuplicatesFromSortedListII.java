package LeetCode_Questions;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

// =============================================================================================
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head, next = head.next, prev = null;
        boolean flag = false;

        while(current != null && next != null){
            int val = current.val;
            while(next != null && next.val == val){
                next = next.next;
                flag = true;
            }
            if(flag){
                flag = false;
                if(current == head) {
                    head = next;
                } else {
                    prev.next = next;
                }
                if(next != null && next.next != null){
                    current = next;
                    next = current.next;
                }
            } else {
                prev = current;
                current = current.next;
                next = current.next;
            }
        }

        return head;
    }
}

// ============================================================================================================================

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        //[1,2,3,3,4,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        head = deleteDuplicates(head);

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode sHead = new ListNode();
        ListNode sTail = sHead;

        while (head != null){
            if(head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
                continue;
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
