package com.atsyc.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doubleyao on 2020-11-10.
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        ListNode q = head;
        while (q != null) {
            if(set.contains(q.val)){
                return true;
            }else {
                set.add(q.val);
            }
            q = q.next;
        }
        return false;
    }


}
