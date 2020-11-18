package com.atsyc.list;

/**
 * Created by doubleyao on 2020-10-21.
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode slow = head;
        ListNode quick = head.next;


        return null;
    }

}
