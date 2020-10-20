package com.atsyc.list;

/**
 * Created by doubleyao on 2020-10-14.
 */

public class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
