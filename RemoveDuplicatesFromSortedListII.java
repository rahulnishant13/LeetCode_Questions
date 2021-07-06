package LeetCode_Questions;

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
