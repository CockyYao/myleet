package com.atsyc.list;

/**
 * Created by doubleyao on 2020-10-21.
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int cnt = k;
        while (cnt > 0) {
            fast = fast.next;
            cnt--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
