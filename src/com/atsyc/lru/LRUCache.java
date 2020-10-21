package com.atsyc.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by doubleyao on 2020-10-20.
 */
public class LRUCache extends LinkedHashMap<Integer,Integer>{

    private int capacity ;

    public LRUCache(int capacity) {
        super(capacity,0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        int x1 = cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        int x2 =cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        int x3 =cache.get(1);       // 返回 -1 (未找到)
        int x4 = cache.get(3);       // 返回  3
        int x5 =cache.get(4);       // 返回  4
    }

}
