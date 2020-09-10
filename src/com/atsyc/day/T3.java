package com.atsyc.day;

import java.util.*;

/**
 * Created by doubleyao on 2020-09-10.
 */
public class T3 {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 0 || candidates == null || candidates.length == 0) {
            return new ArrayList<>(lists);
        }
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates, target, new ArrayList<>(), visited);
        return lists;
    }

    void dfs(int[] candidates, int target, List<Integer> list, boolean[] visited) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if(lists.size() == 0){
                Collections.sort(list);
                lists.add(new ArrayList<>(list));
            }else {
                if(!hasList(list)){
                    lists.add(new ArrayList<>(list));
                }
            }
        }
        for (int i = 0; i < candidates.length; i++) {
            if (visited[i] == false) {
                list.add(candidates[i]);
                visited[i] = true;
                dfs(candidates, target - candidates[i], list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 比较两个list 是否相同
    boolean hasList(List<Integer> list) {
        if (lists == null || lists.size() == 0) {
            return false;
        }
        for (List<Integer> e : lists) {
            if (e.size() != list.size()) {
                return false;
            } else {
                Collections.sort(list);
                for(int i=0;i<list.size();i++){
                    if (!list.get(i).equals(e.get(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("hel");
    }



}
