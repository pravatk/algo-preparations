package my.preparations.leetcode;

public class _2130_MaxTwinSumLL {

    public static void main(String[] args) {
        _2130_MaxTwinSumLL s = new _2130_MaxTwinSumLL();
        ListNode head = ListNode.fromArray(new int[]{5, 4, 2, 1});
        System.out.println(s.pairSum(head));
        System.out.println(s.pairSum(ListNode.fromArray(new int[]{4, 2, 2, 3})));
        System.out.println(s.pairSum(ListNode.fromArray(new int[]{1, 3})));
    }

    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head.next;
        int mx = Integer.MIN_VALUE;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = reverse(slow);
        ListNode head1 = head, head2 = prev;
        while (head2 != null && head1 != null) {
            mx = Math.max(mx, head1.val + head2.val);
            head1 = head1.next;
            head2 = head2.next;
        }
        return mx;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
