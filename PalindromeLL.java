/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = slow, temp = null, temp1 = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp1 = slow.next;
            slow.next = temp;
            temp = slow;
            slow = temp1;
        }

        if (fast != null)
            slow = slow.next;

        while (slow != null && temp != null) {
            if (slow.val != temp.val)
                return false;
            slow = slow.next;
            temp = temp.next;
        }

        return slow == null && temp == null;

    }
}