package my.preparations.leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode start = this;
        while (start != null) {
            System.out.print(start.val + "->");
            start = start.next;
        }
        System.out.print("null");
    }

    public static ListNode fromArray(int[] arr) {
        ListNode dummy = new ListNode(-1), p = dummy;
        for (int j : arr) {
            p.next = new ListNode(j);
            p = p.next;
        }
        return dummy.next;
    }

}
