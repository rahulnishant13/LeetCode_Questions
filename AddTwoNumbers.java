package LeetCode_60_questions_to_solve;

/**
 * Input
 * [9,9,9,9,9,9,9]
 * [9,9,9,9]
 * Output
 * [8,9,9,9]
 * Expected
 * [8,9,9,9,0,0,0,1]
 *
 * Input
 * [2,4,9]
 * [5,6,4,9]
 * Output
 * [7,0,4,10,1]
 * Expected
 * [7,0,4,0,1]
 * */

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(9);
//        head1.next.next.next = new ListNode(9);
//        head1.next.next.next.next = new ListNode(9);
//        head1.next.next.next.next.next = new ListNode(9);
//        head1.next.next.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(9);

        ListNode node = addTwoNumbers(head1, head2);
        while (node!= null){
            System.out.println(node.val+ " ");
            node = node.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head,current;
        int carry = 0;
        current = head = new ListNode((l1.val + l2.val) % 10);
        carry = (l1.val + l2.val)/10;
        l1 = l1.next;
        l2 = l2.next;

        while (l1!=null && l2!=null) {
            current.next = new ListNode((l1.val + l2.val + carry)% 10);
            carry = (l1.val + l2.val + carry)/10;

            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        if(l1!= null){
            while(l1 !=null){
                current.next= new ListNode((l1.val + carry)  % 10);
                carry = (l1.val + carry)/10;
                l1 = l1.next;
                current = current.next;
            }
        }
        if(l2!= null){
            while(l2 !=null){
                current.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry)/10;
                l2 = l2.next;
                current = current.next;
            }
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}