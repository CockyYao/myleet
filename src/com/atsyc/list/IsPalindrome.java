package com.atsyc.list;

import java.util.Stack;

/**
 * Created by doubleyao on 2020-10-21.
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        ListNode q = head;
        while (q != null) {
            int x = q.val;
            int y = stack.pop();
            if (x != y) {
                return false;
            }
            q = q.next;
        }
        return true;
    }

}
