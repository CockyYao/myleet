package com.atsyc.day;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doubleyao on 2020-11-17.
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if(!num_set.contains(num-1)){

                int current = num;
                int tmp = 0;
                while (num_set.contains(num+1)){
                    current = current+1;
                    tmp++;
                }
                if(tmp>res){
                    res = tmp;
                }
            }
        }
        return res;
    }


}
