package LeetCode_Questions;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        Set<ListNode> st = new HashSet<>();
        while(headA != null){
            st.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(!st.add(headB)){
                return headB;
            } else {
                st.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
