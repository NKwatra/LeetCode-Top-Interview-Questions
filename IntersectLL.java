/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode ptr1 = headA, ptr2 = headB;
        int countA = 1, countB = 1;

        while (ptr1.next != null) {
            countA++;
            ptr1 = ptr1.next;
        }

        while (ptr2.next != null) {
            countB++;
            ptr2 = ptr2.next;
        }

        if (ptr1 != ptr2)
            return null;

        ptr1 = headA;
        ptr2 = headB;

        if (countB > countA) {
            int diff = countB - countA;
            while (diff > 0) {
                ptr2 = ptr2.next;
                diff--;
            }
        } else if (countA > countB) {
            int diff = countA - countB;
            while (diff > 0) {
                ptr1 = ptr1.next;
                diff--;
            }
        }

        while (ptr1 != null) {
            if (ptr1 == ptr2)
                return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return null;
    }
}