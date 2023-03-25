package my.preparations.educative.fast_slow_pointer;


class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        // Find mid
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = reverse(slow);
        slow = head;
        fast = revHead;
        boolean result = true;
        while (slow != null && fast != null) {
            if (slow.value != fast.value) {
                result = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        reverse(revHead);
        return result;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
