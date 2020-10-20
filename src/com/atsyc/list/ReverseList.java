package com.atsyc.list;

/**
 * Created by doubleyao on 2020-10-14.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != null) {
            // 先保存一份
            ListNode quickNext = quick.next;
            quick.next = slow;
            slow = quick;
            quick = quickNext;
        }
        head.next = null;
        return slow;
    }

}
