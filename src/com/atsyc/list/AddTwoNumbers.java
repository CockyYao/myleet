package com.atsyc.list;

/**
 * Created by doubleyao on 2020-10-21.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = getNumber(l1);
        int y = getNumber(l2);
        int z = x + y;
        int t = z;

        ListNode head = null;
        ListNode q = null;
        while (t != 0) {
            int val = t % 10;
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                q = head;
            }else {
                q.next = node;
                q = q.next;
            }
            t = t/10;
        }

        return head;

    }

    private int getNumber(ListNode head) {
        if (head == null) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        ListNode p = head;
        while (p != null) {
            int x = (int) Math.pow(10, i);
            sum = sum + x * p.val;
            i++;
        }
        return sum;
    }

}
