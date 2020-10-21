package com.atsyc.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-10-21.
 */
public class ReversePrint {

    private List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        help(head);
        if (list.size() == 0) {
            return new int[0];
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void help(ListNode head) {
        if (head == null) {
            return;
        }
        help(head.next);
        list.add(head.val);
    }

}
