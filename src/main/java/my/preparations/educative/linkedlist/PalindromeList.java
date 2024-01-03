package my.preparations.educative.linkedlist;

public class PalindromeList {
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode mid = slow;
        LinkedListNode reversedMid = LinkedListReversal.reverseLinkedList(mid);

        slow = head;
        LinkedListNode ptr = reversedMid;
        while (slow != null && ptr != null) {
            if (slow.data != ptr.data)
                return false;
            slow = slow.next;
            ptr = ptr.next;
        }
        return true;
    }
}
