package com.atsyc.list;

/**
 * Created by doubleyao on 2020-11-10.
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {

        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);

        ListNode bigHead = big;
        ListNode smallHead = small;


        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        big.next = null;

        return smallHead.next;
    }
}
