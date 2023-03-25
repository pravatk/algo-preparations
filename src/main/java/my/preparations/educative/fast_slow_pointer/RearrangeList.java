package my.preparations.educative.fast_slow_pointer;

class RearrangeList {

    public static void reorder(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = reverse(slow);
        ListNode p = head, q = revHead, p1 = null, q1 = null;
        do {
            p1 = p.next;
            q1 = q.next;
            p.next = q;
            q.next = p1;
            p = p1;
            q = q1;
        } while (p != null && q != null);
        if (p != null) p.next = null;
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
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
