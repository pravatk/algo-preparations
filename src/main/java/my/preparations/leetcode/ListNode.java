package my.preparations.leetcode;

import lombok.Data;

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
}
