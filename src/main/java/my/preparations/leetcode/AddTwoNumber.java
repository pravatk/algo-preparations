package my.preparations.leetcode;

import java.util.Optional;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        ListNode result = null, ptr = null;
        int sum = 0, carry = 0;
        while (l1Ptr != null || l2Ptr != null) {
            sum = carry +
                    (l1Ptr == null ? 0 : l1Ptr.val) +
                    (l2Ptr == null ? 0 : l2Ptr.val);
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                ptr = result;
            } else {
                ptr.next = new ListNode(sum % 10);
                ptr = ptr.next;
            }
            if (l1Ptr != null) l1Ptr = l1Ptr.next;
            if (l2Ptr != null) l2Ptr = l2Ptr.next;
        }
        if (carry > 0) {
            ptr.next = new ListNode(carry);
        }
        return result;
    }


    public static void main(String[] args) {
        AddTwoNumber solution = new AddTwoNumber();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        l3.print();
    }
}
