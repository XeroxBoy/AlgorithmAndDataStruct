package LeetCode.Medium.OS;

import java.util.*;

//class LRUCache {
//    private Map<Integer, Integer> lruMap;
//    private Queue<Integer> queue;
//    private int mapCapacity;
//
//    public LRUCache(int capacity) {
//        lruMap = new ConcurrentHashMap<>(capacity);
//        queue = new LinkedList<>();
//        mapCapacity = capacity;
//    }
//
//    public int get(int key) {
//        if (lruMap.containsKey(key)) {
//            queue.remove(key);
//            queue.offer(key);
//            return lruMap.get(key);
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//            if (lruMap.size() >= mapCapacity && !lruMap.containsKey(key)) {
//                int toDelete = queue.poll();
//                lruMap.remove(toDelete);
//            }
//            if(!queue.contains(key)) queue.offer(key);
//            else{
//                queue.remove(key);
//                queue.offer(key);
//            }
//                lruMap.put(key, value);
//    }
//
//    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
////        cache.put(1, 1);
////        cache.put(2, 2);
////        System.out.println(cache.get(1));     // 返回  1
////        cache.put(3, 3);    // 该操作会使得密钥 2 作废
////        System.out.println(cache.get(2));      // 返回 -1 (未找到)
////        cache.put(4, 4);    // 该操作会使得密钥 1 作废
////        System.out.println(cache.get(1));      // 返回 -1 (未找到)
////        System.out.println(cache.get(3));       // 返回  3
////        cache.get(4);       // 返回  4
////        cache.get(2);
////        cache.put(2,6);
////        cache.get(1);
////        cache.put(1,5);
////        cache.put(1,2);
////        cache.get(1);
////        System.out.println(cache.get(2));
//        cache.put(2,1);
//        cache.put(1,1);
//        cache.put(2,3);
//        cache.put(4,1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//    }
//}
class greatLRU {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

    public greatLRU(int capacity) {
        this.cap = capacity;
    }

    public static void main(String[] args) {
        greatLRU cache = new greatLRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));     // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        cache.get(4);       // 返回  4
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();

            // int firstKey = map.e***ySet().iterator().next().getValue();
            // map.remove(firstKey);
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */