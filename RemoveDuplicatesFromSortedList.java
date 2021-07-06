package LeetCode_Questions;

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

