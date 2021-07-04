package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int maxCapacity;
    private Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.cache = new LinkedHashMap<>();
    }


    public void put(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
        if (cache.size() > this.maxCapacity) {
            for (int k : cache.keySet()) {
                this.cache.remove(k);
                break;
            }
        }
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int val = this.cache.remove(key);
        cache.put(key, val);
        return val;
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
