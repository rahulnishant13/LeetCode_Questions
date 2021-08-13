package LeetCode_Questions;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
//        head.next.next = head;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(hasCycle(head).val);
    }
    public static ListNode hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(slow != head){
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }

        return null;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
